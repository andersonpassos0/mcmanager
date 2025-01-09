package com.mastersystem.mcmanager.domain.service;

import com.mastersystem.mcmanager.application.dto.request.LoginRequest;
import com.mastersystem.mcmanager.infrastructure.util.JwtUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    public String login(LoginRequest loginRequest) {
        log.info("[start] AuthService - login");
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );
        log.info("auth name        : " + auth.getName());
        log.info("auth authorities : " + auth.getAuthorities());
        log.info("auth credentials : " + auth.getCredentials());
        log.info("auth details     : " + auth.getDetails());
        log.info("auth principal   : " + auth.getPrincipal());

        log.info("[finish] AuthService - login");
        return JwtUtil.generateToken(auth.getName());
    }
}
