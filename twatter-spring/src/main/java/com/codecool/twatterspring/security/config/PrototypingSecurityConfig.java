package com.codecool.twatterspring.security.config;

import com.codecool.twatterspring.security.JwtFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@Profile("dev")
public class PrototypingSecurityConfig extends BaseSecurityConfig {

    public PrototypingSecurityConfig(JwtFilter jwtFilter) {
        super(jwtFilter);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http
            .cors()
                .and()
            .csrf()
                .disable()
            .authorizeRequests()
                .antMatchers("/login")
                    .permitAll()
                .anyRequest()
                    .authenticated()
                .and()
            .exceptionHandling()
                .authenticationEntryPoint((req, resp, e) -> resp.sendRedirect("/login"));
    }
}
