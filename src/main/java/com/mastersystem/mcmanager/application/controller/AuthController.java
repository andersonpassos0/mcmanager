package com.mastersystem.mcmanager.application.controller;

import com.mastersystem.mcmanager.application.dto.request.LoginRequest;
import com.mastersystem.mcmanager.application.dto.response.AuthResponse;
import com.mastersystem.mcmanager.domain.service.AuthService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Log4j2
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        log.info("[start] AuthController - login");
        String token = authService.login(loginRequest);
        AuthResponse authResponse = new AuthResponse(token);
        log.info("[finish] AuthController - login");
        return ResponseEntity.ok(authResponse);
    }
}
