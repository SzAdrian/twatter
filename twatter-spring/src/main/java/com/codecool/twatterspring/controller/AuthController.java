package com.codecool.twatterspring.controller;

import com.codecool.twatterspring.model.AuthDTO;
import com.codecool.twatterspring.security.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@RestController
@RequestMapping("/api/auth")
@Slf4j
@CrossOrigin
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
    
    @PostMapping("register")
    public boolean register(@RequestBody AuthDTO registrationDTO) {
        log.info("Registration request received: " + registrationDTO.toString());
        return authService.tryRegister(registrationDTO);
    }
    @GetMapping("/isloggedin")
    public ResponseEntity<Object> me(HttpServletRequest http) {
        System.out.println(Arrays.toString(http.getCookies()));
        if (!SecurityContextHolder.getContext()
                .getAuthentication().isAuthenticated()) {
            return ResponseEntity.status(403).body("No user!");
        }
        return  ResponseEntity.ok(SecurityContextHolder.getContext()
                .getAuthentication().getCredentials());

    }
}
