package com.codecool.twatterspring.security.config;

import com.codecool.twatterspring.controller.AuthController;
import com.codecool.twatterspring.model.AuthDTO;
import com.codecool.twatterspring.security.service.AuthService;
import com.codecool.twatterspring.security.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.Cookie;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({AuthController.class})
class AuthControllerSecurityTest extends AbstractControllerSecurityTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AuthService authService;
    
    @Autowired
    private JwtService jwtService;
    
    @Test
    void smokeTest() {
    }
    
    @Test
    void unauthenticatedUserCannotLogout() throws Exception {
        mockMvc.perform(post(BASE_URL + "/auth/logout"))
            .andExpect(status().isForbidden());
    }
    
    @Test
    void authenticatedUserCanLogout() throws Exception {
        mockMvc.perform(
            post(BASE_URL + "/auth/logout")
                .cookie(createTokenCookie()))
            .andExpect(status().isOk());
    }
    
    @Test
    void anyoneCanTryToRegister() throws Exception {
        AuthDTO dto = AuthDTO.builder().username("non_existent_user").password("pass").build();
        String json = mapper.writeValueAsString(dto);

        mockMvc.perform(
            post(BASE_URL + "/auth/register")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        )
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().string("true"));
    }

    @Test
    void anyoneCanTryToLogin() throws Exception {
        AuthDTO dto = AuthDTO.builder().username("user").password("user").build();
        String json = mapper.writeValueAsString(dto);

        mockMvc.perform(
            post(BASE_URL + "/auth/login")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        )
            .andExpect(status().isOk());
    }
    
    private Cookie createTokenCookie() {
        String token = jwtService.createToken("user", List.of("USER"));
        return authService.createTokenCookie(token);
    } 
}