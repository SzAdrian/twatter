package com.codecool.twatterspring.model;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class TwatterUser {
    private String username;
    private String password;
    @Singular
    private List<String> roles;

    private List<GrantedAuthority> getGrantedAuthorities() {
        return roles.stream()
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
    }

    public UserDetails asUserDetails() {
        return User.builder()
            .username(username)
            .password(password)
            .authorities(getGrantedAuthorities())
            .build();
    }
}
