package com.mastersystem.mcmanager.infrastructure.config;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private final String username;


    public JwtAuthenticationToken(String username) {
        super(Collections.emptyList());
        this.username = username;
    }

    public JwtAuthenticationToken(String username, boolean authenticated){
        super(Collections.singletonList(new SimpleGrantedAuthority("USER")));
        this.username = username;
        setAuthenticated(authenticated);
    }

    public String getUsername(){
        return username;
    }

    @Override
    public Object getCredentials(){
        return null;
    }

    @Override
    public Object getPrincipal(){
        return username;
    }
}
