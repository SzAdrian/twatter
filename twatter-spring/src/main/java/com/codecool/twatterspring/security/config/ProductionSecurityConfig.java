package com.codecool.twatterspring.security.config;

import com.codecool.twatterspring.security.JwtFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Profile({"test & security", "prod"})
@Configuration
public class ProductionSecurityConfig extends BaseSecurityConfig {

    public ProductionSecurityConfig(JwtFilter jwtFilter) {
        super(jwtFilter);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.csrf().disable()
            .authorizeRequests()
            .anyRequest()
            .authenticated();
    }
}
