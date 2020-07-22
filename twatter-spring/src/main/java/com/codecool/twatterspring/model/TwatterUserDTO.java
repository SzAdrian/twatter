package com.codecool.twatterspring.model;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class TwatterUserDTO {
    private Long id;
    private String username;
    private String email;
    private LocalDateTime registrationDate;
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

    public static TwatterUserDTO fromEntity(TwatterUser twatterUser) {
        return TwatterUserDTO.builder()
            .id(twatterUser.getId())
            .username(twatterUser.getName())
            .password(twatterUser.getPassword())
            .email(twatterUser.getEmail())
            .registrationDate(twatterUser.getRegistrationDate())
            .role("USER")
            .build();
    }
}
