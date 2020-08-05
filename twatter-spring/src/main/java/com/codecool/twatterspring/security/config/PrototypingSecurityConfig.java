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
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:3000"));

        // First I included "OPTIONS" as well, but it works without it
        configuration.setAllowedMethods(List.of("HEAD", "GET", "POST", "PUT", "DELETE"));
        // This is absolutely necessary
        configuration.setAllowCredentials(true);
        // This is from Stack Overflow, with the addition of the last header
        // I checked, and it only works if it's there
        configuration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type", "Access-Control-Allow-Credentials"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
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
                    .authenticated();

    }
}
