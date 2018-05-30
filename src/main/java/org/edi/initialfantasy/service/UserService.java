package org.edi.initialfantasy.service;

import org.edi.initialfantasy.bo.user.User;
import org.edi.initialfantasy.bo.userauthrization.UserAuth;
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
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/userauthrization")
    public String Login(@QueryParam("EncAccount") String EncAccount,
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



    @DELETE
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    @Path("userauthrization")
    public String Logout(String logoutInfo) {
        return null;
    }


    @GET
    @Path("/getname")
    @Produces("text/plain")
    public String UserLogin(){
        return "hello";
    }
}
