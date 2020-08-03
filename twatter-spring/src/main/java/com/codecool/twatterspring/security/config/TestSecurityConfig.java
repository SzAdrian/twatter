package com.codecool.twatterspring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Profile("test")
@Configuration
public class TestSecurityConfig extends BaseSecurityConfig {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable()
            .csrf().disable()
            .authorizeRequests()
                .anyRequest().permitAll();
    }
}
