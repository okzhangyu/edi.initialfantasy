package org.edi.initialfantasy.service;

import org.edi.initialfantasy.bo.user.User;
import org.edi.initialfantasy.bo.userauthrization.UserAuth;
import org.edi.initialfantasy.dto.IResult;
import org.edi.initialfantasy.dto.IUserAuthrizationRes;
import org.edi.initialfantasy.dto.IUserAuthrization;
import org.edi.initialfantasy.repository.UserAuthMapper;
import org.edi.initialfantasy.repository.UserMapper;
import org.edi.initialfantasy.util.MD5Util;
import org.edi.initialfantasy.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/userauthrization")
    public String UserLogin(@QueryParam("EncAccount") String EncAccount,
                                    @QueryParam("EncPassword") String EncPassword) {
        String status = "";
        try {
            User loginUser =  userDao.getUserByName(EncAccount);
            String hmacPassword = MD5Util.byteArrayToHexString(MD5Util.encryptHMAC(loginUser.getMobilePassword().getBytes(),"avatech"));
            String authToken = UUIDUtil.randomUUID32();
            UserAuth userRecord = new UserAuth(loginUser.getUserName(),loginUser.getIsMobileUser(),"客户",authToken,"1","Y");
            userAuthDao.saveLoginRecord(userRecord);
            if (hmacPassword.equals(EncPassword)) {
                status = "Login Success";
            } else {
                status = "Login Fail";
            }
        } catch (Exception e) {
            status = e.getMessage().toString();
        }
        return status;

    }


    @POST
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/userauthrization")
    public IResult<IUserAuthrizationRes> Login(IUserAuthrization userAuthrization) {
        String status = "";
        try {
            //TODO
            //1.根据companyName查找companyId
            //2.根据companyId、userName、password查找是否存在用户对象
            //3.根据查找的用户对象的userId查找授权表是否存在记录
            //  3.1、不存在记录，则新建一条记录
            //  3.2、存在记录，但是token不可用，则延长过期时间
            //  3.3、存在记录，token可用，直接返回token

        } catch (Exception e) {
            status = e.getMessage().toString();
        }
        return null;

    }


    @DELETE
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    @Path("userauthrization")
    public String Logout(String logoutInfo) {
        return null;
    }


}
