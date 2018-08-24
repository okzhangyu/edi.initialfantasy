package org.edi.initialfantasy.service;

import org.edi.freamwork.cryptogram.MD5Util;
import org.edi.freamwork.data.IResult;
import org.edi.freamwork.data.Result;
import org.edi.freamwork.exception.BusinessException;
import org.edi.freamwork.exception.DBException;
import org.edi.initialfantasy.bo.company.Company;
import org.edi.initialfantasy.bo.user.User;
import org.edi.initialfantasy.bo.userauthrization.UserAuth;
import org.edi.initialfantasy.data.DataConvert;
import org.edi.initialfantasy.data.ResultCode;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.data.ServicePath;
import org.edi.initialfantasy.dto.IUserAuthrizationResult;
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
            UserAuthrizationResult uaResult = boRepositoryUserAuth.getAuthrization(companyName,userName,password);
            listResult.add(uaResult);
            rs = new Result(ResultCode.SUCCESS, ResultDescription.OK, listResult);
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
            boRepositoryUserAuth.updateAuth(auth);
            result = new Result(ResultCode.SUCCESS, ResultDescription.OK, null);
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
