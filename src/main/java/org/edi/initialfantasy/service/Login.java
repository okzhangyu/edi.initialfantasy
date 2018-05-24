package org.edi.initialfantasy.service;

import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Fancy
 * @date 2018/5/17
 */
@Path("login")
public class Login {
    private static Logger logger = Logger.getLogger(Login.class);
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("sayHello")
    public String sayHello(){
        logger.info("You call sayHello function.");
        return "Hello,I am text!";
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("sayGood")
    public String sayHtmlHello() {
        return "<html> " + "<title>" + "Hello Jersey" + "</title>"
                + "<body><h1>" + "Hello,I am html!" + "</body></h1>" + "</html> ";
    }
}
