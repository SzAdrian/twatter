package com.codecool.twatterspring.security.config;

import com.codecool.twatterspring.security.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@Profile({"development", "no_db & !security"})
public class PrototypingSecurityConfig extends BaseSecurityConfig {

    public PrototypingSecurityConfig(JwtFilter jwtFilter) {
        super(jwtFilter);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http
            .csrf()
                .disable()
            .authorizeRequests()
                .antMatchers("/dev/login")
                    .permitAll()
                .anyRequest()
                    .authenticated();

    }
}
