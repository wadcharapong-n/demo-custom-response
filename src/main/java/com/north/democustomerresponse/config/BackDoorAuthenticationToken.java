package com.north.democustomerresponse.config;

import com.north.democustomerresponse.model.UserProfile;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public class BackDoorAuthenticationToken extends AbstractAuthenticationToken {

    private final UserProfile principal;
    private final Object credentials;

    public BackDoorAuthenticationToken(UserProfile principal) {
        super(List.of(new SimpleGrantedAuthority("GOD")));
        this.principal = principal;
        this.credentials = null;
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }
}
