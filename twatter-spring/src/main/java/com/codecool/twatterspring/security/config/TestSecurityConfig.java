package com.codecool.twatterspring.security.config;

import com.codecool.twatterspring.security.JwtFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Profile("test & !security")
@Configuration
public class TestSecurityConfig extends BaseSecurityConfig {

    public TestSecurityConfig(JwtFilter jwtFilter) {
        super(jwtFilter);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable()
            .csrf().disable()
            .authorizeRequests()
                .anyRequest().permitAll();
    }
}
