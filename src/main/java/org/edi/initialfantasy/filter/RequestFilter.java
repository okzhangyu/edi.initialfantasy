package org.edi.initialfantasy.filter;

import org.edi.initialfantasy.binding.UserRequest;
import org.edi.initialfantasy.util.TokenVerification;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
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

    @Autowired
    private TokenVerification tokenVerification;
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        //记录请求日志
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println(containerRequestContext.getUriInfo().getRequestUri().getQuery().toString().substring(6));
        String msg = tokenVerification.verification(containerRequestContext.getUriInfo().getRequestUri().getQuery().toString().substring(6));
        System.out.println(msg);
        System.out.println("----------------------------------------------------------------------------------------------");
        //判断token是否有效--除登陆接口外

    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        //记录返回日志

    }
}
