package org.edi.initialfantasy.service;

import org.edi.freamwork.cryptogram.MD5Util;
import org.edi.freamwork.exception.BusinessException;
import org.edi.freamwork.exception.DBException;
import org.edi.initialfantasy.bo.company.Company;
import org.edi.initialfantasy.bo.user.User;
import org.edi.initialfantasy.bo.userauthrization.UserAuth;
import org.edi.initialfantasy.data.DataConvert;
import org.edi.initialfantasy.data.ResultCode;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.data.ServicePath;
import org.edi.initialfantasy.dto.IResult;
import org.edi.initialfantasy.dto.IUserAuthrizationResult;
import org.edi.initialfantasy.dto.Result;
import org.edi.initialfantasy.dto.UserAuthrizationResult;
import org.edi.initialfantasy.filter.UserRequest;
import org.edi.initialfantasy.repository.IBORepositoryCompany;
import org.edi.initialfantasy.repository.IBORepositoryUser;
import org.edi.initialfantasy.repository.IBORepositoryUserAuth;
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
    private IBORepositoryUser boRepositoryUser;
    @Autowired
    private IBORepositoryUserAuth boRepositoryUserAuth;
    @Autowired
    private IBORepositoryCompany boRepositoryCompany;




    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/userauthrization")
    public IResult<IUserAuthrizationResult> Login(@QueryParam("companyName")String companyName,@QueryParam("userName")String userName,@QueryParam("password")String password) {
        Result rs ;
        List<UserAuthrizationResult> listResult = new ArrayList<UserAuthrizationResult>();
        try {
            Company company = boRepositoryCompany.serchCompanyId(companyName);
            if(company==null){
                throw new BusinessException(ResultCode.COMPANY_IS_NONEXISTENT,ResultDescription.COMPANY_IS_NONEXISTENT);
            }
            User loginUser =  boRepositoryUser.getUserByCompanyId(userName,company.getCompanyId());
            if(loginUser==null){
                throw new BusinessException(ResultCode.USER_IS_NONEXISTENT,ResultDescription.USER_IS_NONEXISTENT);
            }
            String hmacPassword = MD5Util.byteArrayToHexString(MD5Util.encryptHMAC(loginUser.getMobilePassword().getBytes(),"avatech"));
            if (hmacPassword.equals(password)) {
                //用户密码正确，获取截止到登录日期后一天的13位时间戳作为有效期
                long NextDayTimeMillis = Long.parseLong(DataConvert.dateToStamp());
                //对用户登录记录进行处理
                UserAuthrizationResult uaResult = boRepositoryUserAuth.processUserLoginRecord(loginUser,NextDayTimeMillis);
                listResult.add(uaResult);
                rs = new Result(ResultCode.OK, ResultDescription.OK, listResult);
            } else {
                rs = new Result(ResultCode.USERPASSWORD_IS_ERROR,ResultDescription.USERPASSWORD_IS_ERROR, listResult);
            }
        }catch (DBException e){
            rs = new Result(e);
        }catch (BusinessException e){
            rs = new Result(e);
        }catch (Exception e){
            e.printStackTrace();
            rs = new Result(ResultCode.FAIL, e);
        }
        return rs;
    }


    @UserRequest
    @DELETE
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/userauthrization")
    //用户退出
    public IResult Logout(@QueryParam(ServicePath.TOKEN_NAMER)String token) {
        Result result ;
        UserAuth auth = boRepositoryUserAuth.serchAuthByToken(token);
        try {
            auth.setIsActive("N");
            auth.setAuthToken("");
            boRepositoryUserAuth.updateActive(auth);
            result = new Result(ResultCode.OK, ResultDescription.OK, null);
        }catch (DBException e){
            result = new Result(e);
        }catch (BusinessException e){
            result = new Result(e);
        }catch (Exception e){
            e.printStackTrace();
            result = new Result(ResultCode.FAIL, e);
        }
        return result;
    }

}
