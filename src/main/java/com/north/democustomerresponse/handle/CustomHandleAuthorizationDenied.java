package com.north.democustomerresponse.handle;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.authorization.AuthorizationResult;
import org.springframework.security.authorization.method.MethodAuthorizationDeniedHandler;
import org.springframework.security.authorization.method.MethodInvocationResult;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static com.north.democustomerresponse.util.MarkingUtil.markingValue;

@Component
public class CustomHandleAuthorizationDenied implements MethodAuthorizationDeniedHandler {

    // for @PostAuthorize
    @Override
    public Object handleDeniedInvocationResult(MethodInvocationResult methodInvocationResult, AuthorizationResult authorizationResult) {
        Object result = methodInvocationResult.getResult();
        if (result == null) {
            return null;
        } else if (String.class.isAssignableFrom(result.getClass())) {
            return "You can't see me.";
        } else if (BigDecimal.class.isAssignableFrom(result.getClass())) {
            BigDecimal value = (BigDecimal) result;
            return markingValue(value);
        } else {
            return null;
        }
    }
    // for @PreAuthorize
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
