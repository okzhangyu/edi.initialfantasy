package org.edi.initialfantasy.service;

import org.edi.freamwork.data.IResult;
import org.edi.freamwork.data.Result;
import org.edi.freamwork.exception.AuthrizationException;
import org.glassfish.jersey.server.JSONP;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * @author Fancy
 * @date 2018/8/1
 */
@Path("/v1")
public class AuthrizationService implements IAuthrizationService{

    public static final String MESSAGE = "message";

    @GET
    @JSONP(queryParam="callback")
    @Produces("application/x-javascript;charset=utf-8")
    @Path("/userauthrization/errortoken")
    @Override
    public IResult authrizeForErrorToken(@QueryParam(MESSAGE)String message) {
        return new Result(new AuthrizationException(message));
    }
}
