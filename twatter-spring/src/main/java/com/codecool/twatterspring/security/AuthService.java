package com.codecool.twatterspring.security;

import com.codecool.twatterspring.model.AuthDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public static final String TOKEN_COOKIE_NAME = "JWT";

    public AuthService(AuthenticationManager authenticationManager,
                       JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public boolean tryLogin(AuthDTO loginDTO, HttpServletResponse response) {
        Authentication authentication = tryAuthenticate(loginDTO);
        return login(authentication, response);
    }

    private Authentication tryAuthenticate(AuthDTO loginDTO) {
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword())
            );
        } catch (AuthenticationException ignored) {
        }
        return authentication;
    }

    private boolean login(Authentication authentication, HttpServletResponse response) {
        if (authentication == null)
            return false;

        List<String> roles = getRolesFrom(authentication);
        String username = authentication.getName();
        String token = jwtService.createToken(username, roles);
        Cookie tokenCookie = createTokenCookie(token);
        response.addCookie(tokenCookie);
        return true;
    }

    private List<String> getRolesFrom(Authentication authentication) {
        return authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.toList());
    }

    private Cookie createTokenCookie(String jwt) {
        Cookie tokenCookie = new Cookie(TOKEN_COOKIE_NAME, jwt);
        tokenCookie.setHttpOnly(true);
        tokenCookie.setPath("/");
        return tokenCookie;
    }

    public void logout(HttpServletResponse response) {
        invalidateTokenCookie(response);
    }

    private void invalidateTokenCookie(HttpServletResponse response) {
        log.info("Invalidating JWT cookie...");
        Cookie cookie = new Cookie(TOKEN_COOKIE_NAME, "");
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
