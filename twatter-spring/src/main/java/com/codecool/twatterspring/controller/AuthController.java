package com.codecool.twatterspring.controller;

import com.codecool.twatterspring.model.AuthDTO;
import com.codecool.twatterspring.security.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("auth")
@Slf4j
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "login", consumes = "application/x-www-form-urlencoded")
    public boolean formLogin(AuthDTO loginDTO, HttpServletResponse response) {
        log.info("Login request received: " + loginDTO.toString());
        return authService.tryLogin(loginDTO, response);
    }

    @PostMapping(value = "login", consumes = "application/json")
    public boolean login(@RequestBody AuthDTO loginDTO, HttpServletResponse response) {
        log.info("Login request received: " + loginDTO.toString());
        return authService.tryLogin(loginDTO, response);
    }
    
    @PostMapping("logout")
    public void logout(HttpServletResponse response) {
        log.info("Logging out...");
        authService.logout(response);
    }
}
