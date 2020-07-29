package com.codecool.twatterspring.security.config;

import com.codecool.twatterspring.security.JwtFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@Profile({"development", "no_db"})
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
                .antMatchers("/dev/login")
                    .permitAll()
                .anyRequest()
                    .authenticated()
                .and()
            .exceptionHandling()
                .authenticationEntryPoint((req, resp, e) -> resp.sendRedirect("/dev/login"));
    }
}