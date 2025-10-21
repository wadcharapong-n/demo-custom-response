package com.north.democustomerresponse.annotation;

import org.springframework.security.test.context.support.WithSecurityContext;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithMockTestUserSecurityContextFactory.class)
public @interface WithMockTestUser {
    long id() default 1L;

    String username() default "admin";

    String[] roles() default {"admin"};

    String[] authorities() default {};

    boolean canSeeSensitive() default true;
}
