package org.edi.initialfantasy.service;

import org.edi.freamwork.cryptogram.MD5Util;
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
import org.glassfish.jersey.server.JSONP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Fancy
 * @date 2018/5/25
 */
@Path("/v1")
@Transactional
public class UserService implements IUserService{

    @Autowired
    private IBORepositoryUser boRepositoryUser;
    @Autowired
    private IBORepositoryUserAuth boRepositoryUserAuth;
    @Autowired
    private IBORepositoryCompany boRepositoryCompany;




    @GET
    @Override
    @JSONP(queryParam="callback")
    @Produces("application/x-javascript;charset=utf-8")
    @Path("/userauthrization")
    public IResult<IUserAuthrizationResult> Login(@QueryParam("companyName")String companyName,@QueryParam("userName")String userName,@QueryParam("password")String password) {
        Result rs = new Result();
        UserAuthrizationResult uaResult = new UserAuthrizationResult();
        List<UserAuthrizationResult> listResult = new ArrayList<UserAuthrizationResult>();
        try {
            //根据公司名称和用户名查询用户信息，并且为密码参数进行MD5加密与用户密码进行比对
            Company company = boRepositoryCompany.serchCompanyId(companyName);
            User loginUser =  boRepositoryUser.getUserByCompanyId(userName,company.getCompanyId());
            String hmacPassword = MD5Util.byteArrayToHexString(MD5Util.encryptHMAC(loginUser.getMobilePassword().getBytes(),"avatech"));
            if (hmacPassword.equals(password)) {
                //用户密码正确，获取截止到登录日期后一天的13位时间戳作为有效期
                long NextDayTimeMillis = Long.parseLong(DataConvert.dateToStamp());
                //对用户登录记录进行处理
                 uaResult = boRepositoryUserAuth.processUserLoginRecord(loginUser,NextDayTimeMillis);
                listResult.add(uaResult);
                rs = new Result(ResultCode.OK, ResultDescription.OK, listResult);
            } else {
                rs = new Result(ResultCode.USERPASSWORD_IS_ERROR,"fail:"+ResultDescription.USERPASSWORD_IS_ERROR, listResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            rs = new Result(ResultCode.FAIL, "fail:"+(e.getCause()==null?e.getMessage():e.getCause().toString()), listResult);
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
        Result result = new Result();
            UserAuth auth = boRepositoryUserAuth.serchAuthByToken(token);
        try {
            auth.setIsActive("N");
            boRepositoryUserAuth.updateActive(auth);
            result = new Result("0", "ok", null);
        }catch (Exception e){
            e.printStackTrace();
            result = new Result("0", "failed:"+e.getCause(), null);
        }
        return result;
    }



    @GET
    @Path("/getname")
    @Produces("text/plain")
    public String UserLogin(){
        return "hello";
    }
}
