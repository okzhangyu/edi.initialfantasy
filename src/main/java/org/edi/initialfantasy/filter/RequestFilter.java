package org.edi.initialfantasy.filter;

import org.apache.log4j.Logger;
import org.edi.initialfantasy.data.ServicePath;
import org.edi.initialfantasy.dto.AuthrizationException;
import org.edi.initialfantasy.dto.Result;
import org.edi.initialfantasy.util.TokenVerification;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * @author Fancy
 * @date 2018/6/5
 */
@Provider
@UserRequest
@Priority(Priorities.USER)
public class RequestFilter implements ContainerRequestFilter,ContainerResponseFilter {
    private static Logger log = Logger.getLogger(RequestFilter.class);

    @Autowired
    private TokenVerification tokenVerificate;
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
             log.warn(containerRequestContext.getDate());
        //记录请求日志
        try{
            MultivaluedMap<String, String> params = containerRequestContext.getUriInfo().getQueryParameters();
            tokenVerificate.verification(params.getFirst(ServicePath.TOKEN_NAMER));
        }catch (AuthrizationException e){
            Response response = Response.ok(new Result(e)).type(MediaType.APPLICATION_JSON).build();
            throw new WebApplicationException(response);
        }
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        //记录返回日
        // containerResponseContext.getHeaders().add("Content-Type", "application/json; charset=utf-8");
    }

}
