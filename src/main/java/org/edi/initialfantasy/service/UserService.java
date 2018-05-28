package org.edi.initialfantasy.service;

import org.edi.initialfantasy.bo.user.IUser;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author Fancy
 * @date 2018/5/25
 */
@Path("v1")
public class UserService implements IUserService{


    @POST
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    @Path("userauthrization")
    public String Login(String loginInfo) {
        return null;
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
