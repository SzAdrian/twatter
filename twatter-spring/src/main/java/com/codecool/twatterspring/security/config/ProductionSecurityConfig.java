package com.codecool.twatterspring.security.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class ProductionSecurityConfig extends BaseSecurityConfig {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }
}
