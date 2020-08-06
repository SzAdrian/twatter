package com.codecool.twatterspring.controller;

import com.codecool.twatterspring.model.AuthDTO;
import com.codecool.twatterspring.security.service.AuthService;
import com.codecool.twatterspring.security.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth")
@Slf4j
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    private final JwtService jwtService;

    public AuthController(AuthService authService,JwtService jwtService) {
        this.authService = authService;
        this.jwtService = jwtService;
    }

    @PostMapping(value = "login", consumes = "application/x-www-form-urlencoded")
    public Long formLogin(AuthDTO loginDTO, HttpServletResponse response) {
        log.info("Login request received: " + loginDTO.toString());
        return authService.tryLogin(loginDTO, response);
    }

    @PostMapping(value = "login", consumes = "application/json")
    public Long login(@RequestBody AuthDTO loginDTO, HttpServletResponse response) {
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
    public ResponseEntity<Object> me(@CookieValue(value="JWT" ,required=false) String jwt) {
        if(jwt == null) return ResponseEntity.status(200).body(false);
        boolean isValidated = jwtService.validateToken(jwt);
        if (!isValidated) {
            return ResponseEntity.status(200).body(false);
        }
        return  ResponseEntity.status(200).body(true);
    }
}
