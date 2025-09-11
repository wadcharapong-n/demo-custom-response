package com.north.democustomerresponse.handle;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.authorization.AuthorizationResult;
import org.springframework.security.authorization.method.MethodAuthorizationDeniedHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class CustomHandleAuthorizationDenied implements MethodAuthorizationDeniedHandler {

    @Override
    public Object handleDeniedInvocation(MethodInvocation methodInvocation, AuthorizationResult authorizationResult) {
        Class<?> returnType = methodInvocation.getMethod().getReturnType();
        if (String.class.isAssignableFrom(returnType)) {
            return "You can't see me.";
        } else {
            return null;
        }
    }
}
