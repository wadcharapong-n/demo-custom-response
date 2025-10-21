package com.north.democustomerresponse.annotation;

import com.north.democustomerresponse.model.UserProfile;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import java.util.Arrays;
import java.util.stream.Stream;

public class WithMockTestUserSecurityContextFactory implements WithSecurityContextFactory<WithMockTestUser> {

    @Override
    public SecurityContext createSecurityContext(WithMockTestUser annotation) {
        var context = SecurityContextHolder.createEmptyContext();

        var authorities = (annotation.authorities().length > 0
                ? Arrays.stream(annotation.authorities())
                : Stream.of(annotation.roles()).map(r -> "ROLE_" + r))
                .map(SimpleGrantedAuthority::new)
                .toList();

        var principal = new UserProfile();
        principal.setUsername(annotation.username());
        principal.setCanSeeSensitiveData(annotation.canSeeSensitive());
        principal.setId(annotation.id());

        var auth = new UsernamePasswordAuthenticationToken(principal, "password", authorities);

        context.setAuthentication(auth);
        return context;
    }
}