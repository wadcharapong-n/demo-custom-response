package com.north.democustomerresponse.annotation;

import com.north.democustomerresponse.handle.CustomHandleAuthorizationDenied;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authorization.method.HandleAuthorizationDenied;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@PreAuthorize("@sensitiveDataService.isSensitiveData(authentication.principal)")
@HandleAuthorizationDenied(handlerClass = CustomHandleAuthorizationDenied.class)
public @interface SensitiveData {

}