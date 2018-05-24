package org.edi.initialfantasy.service;

import org.edi.initialfantasy.bo.Vuser;
import org.edi.initialfantasy.repository.VuserMapper;
import org.edi.initialfantasy.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * @author Fancy
 * @date 2018/5/17
 */
@Path("/login")
public class LoginService {
    @Autowired
    private VuserMapper vuserdao;
    @Autowired
    private MD5Util MD5Util;
    @GET
    @Path("/userlogin")
    @Produces("text/plain")
    public String UserLogin(@QueryParam("EncAccount") String EncAccount,
                            @QueryParam("EncPassword") String EncPassword){
        String status = "";
        try {
            Vuser loginUser = vuserdao.getUserByName(EncAccount);
            String hmacPassword = MD5Util.byteArrayToHexString(MD5Util.encryptHMAC(loginUser.getMobile_password().getBytes(),"avatech"));
            if (hmacPassword.equals(EncPassword)) {
                status = loginUser.getUser_name();
            } else {
                status = "没有该用户";
            }
        } catch (Exception e) {
            status = e.getMessage();
        }
        return status;
    }
    @GET
    @Path("/getname")
    @Produces("text/plain")
    public String UserLogin(){
        return "hello";
    }

}
