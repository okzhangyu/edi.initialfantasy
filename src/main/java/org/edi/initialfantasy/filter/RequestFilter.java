package org.edi.initialfantasy.filter;

import org.edi.initialfantasy.data.ServicePath;
import org.edi.initialfantasy.dto.AuthrizationException;
import org.edi.initialfantasy.util.TokenVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoaderListener;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Map;

/**
 * @author Fancy
 * @date 2018/6/5
 */
@Provider
@UserRequest
@Priority(Priorities.USER)
public class RequestFilter implements ContainerRequestFilter,ContainerResponseFilter {

    @Autowired
    private TokenVerification tokenVerificate;
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        try {
            MultivaluedMap<String, String> params = containerRequestContext.getUriInfo().getQueryParameters();
            if(!params.containsKey(ServicePath.TOKEN_NAMER)) {
                throw new AuthrizationException();
            }
            //记录请求日志
            String msg = tokenVerificate.verification(params.getFirst(ServicePath.TOKEN_NAMER));
            if(!msg.equals("ok")){
                throw new AuthrizationException(msg);
            }
            //判断token是否有效--除登陆接口外


        } catch (AuthrizationException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        //记录返回日志

    }

}
