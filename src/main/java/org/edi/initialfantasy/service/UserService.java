package org.edi.initialfantasy.service;

import org.edi.freamwork.data.IResult;
import org.edi.freamwork.data.Result;
import org.edi.freamwork.exception.BusinessException;
import org.edi.freamwork.exception.DBException;
import org.edi.initialfantasy.bo.userauthrization.UserAuth;
import org.edi.initialfantasy.data.ResultCode;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.data.ServicePath;
import org.edi.initialfantasy.dto.IUserAuthrizationResult;
import org.edi.initialfantasy.dto.UserAuthrizationResult;
import org.edi.initialfantasy.filter.UserRequest;
import org.edi.initialfantasy.repository.IBORepositoryCompany;
import org.edi.initialfantasy.repository.IBORepositoryUser;
import org.edi.initialfantasy.repository.IBORepositoryUserAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger = LoggerFactory.getLogger(UserService.class);

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
            logger.info(ResultDescription.LOGIN_EXCEPTION,e);
            rs = new Result(e);
        }catch (BusinessException e){
            logger.info(ResultDescription.LOGIN_EXCEPTION,e);
            rs = new Result(e);
        }catch (Exception e){
            logger.info(ResultDescription.LOGIN_EXCEPTION,e);
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
            logger.info(ResultDescription.LOGIN_EXCEPTION,e);
            result = new Result(e);
        }catch (BusinessException e){
            logger.info(ResultDescription.LOGIN_EXCEPTION,e);
            result = new Result(e);
        }catch (Exception e){
            logger.info(ResultDescription.LOGIN_EXCEPTION,e);
            e.printStackTrace();
            result = new Result(ResultCode.FAIL, e);
        }
        return result;
    }

}
