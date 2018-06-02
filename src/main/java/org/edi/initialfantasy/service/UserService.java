package org.edi.initialfantasy.service;

import org.edi.initialfantasy.bo.company.Company;
import org.edi.initialfantasy.bo.user.User;
import org.edi.initialfantasy.bo.userauthrization.UserAuth;
import org.edi.initialfantasy.data.DataConvert;
import org.edi.initialfantasy.dto.*;
import org.edi.initialfantasy.repository.CompanyMapper;
import org.edi.initialfantasy.repository.UserAuthMapper;
import org.edi.initialfantasy.repository.UserMapper;
import org.edi.initialfantasy.util.MD5Util;
import org.edi.initialfantasy.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/25
 */
@Path("/v1")
public class UserService implements IUserService{
    @Autowired
    private UserMapper userDao;
    @Autowired
    private UserAuthMapper userAuthDao;
    @Autowired
    private CompanyMapper companyDao;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/userauthrization")
    public IResult<IUserAuthrizationResult> Login(Userauthrization userauthrization) {
        Result rs = new Result();
        UserAuthrizationResult uaResult = new UserAuthrizationResult();
        List<UserAuthrizationResult> listResult = new ArrayList<UserAuthrizationResult>();
        try {
            Company company = companyDao.serchCompanyId(userauthrization.getCompanyName());
            User loginUser =  userDao.getUserByCompanyId(userauthrization.getUserName(),company.getCompanyId());
            String hmacPassword = MD5Util.byteArrayToHexString(MD5Util.encryptHMAC(loginUser.getMobilePassword().getBytes(),"avatech"));
            if (hmacPassword.equals(userauthrization.getPassword())) {
            long NextDayTimeMillis = Long.parseLong(DataConvert.dateToStamp());
            UserAuth userRecord = userAuthDao.serchLoginRecord(loginUser.getUserName());
            if(userRecord==null) {
                String authToken = UUIDUtil.randomUUID32();
                userRecord = new UserAuth(loginUser.getUserName(), loginUser.getIsMobileUser(), "客户", authToken, NextDayTimeMillis, "Y");
                userAuthDao.saveLoginRecord(userRecord);
                uaResult = new UserAuthrizationResult(authToken,NextDayTimeMillis);
            }else{
                Long currentTimeMillis = System.currentTimeMillis();
                if(currentTimeMillis<userRecord.getAuthExpires()){
                     uaResult = new UserAuthrizationResult(userRecord.getAuthToken(),userRecord.getAuthExpires());
                }else{
                    UserAuth userAuth = new UserAuth(userRecord.getUserId(),NextDayTimeMillis);
                    userAuthDao.updateAuthExpires(userAuth);
                    uaResult = new UserAuthrizationResult(userRecord.getAuthToken(),NextDayTimeMillis);
                }
            }
                listResult.add(uaResult);
                rs = new Result("0", "ok", listResult);
            } else {
                rs = new Result("1", "fail", listResult);
            }
        } catch (Exception e) {
         e.printStackTrace();
            rs = new Result("1", "fail", listResult);
        }
        return rs;

    }




    @DELETE
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    @Path("userauthrization")
    public String Logout(String logoutInfo) {
        return null;
    }


}
