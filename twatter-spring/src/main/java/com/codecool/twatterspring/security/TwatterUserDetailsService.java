package com.codecool.twatterspring.security;

import com.codecool.twatterspring.model.TwatterUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class TwatterUserDetailsService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final List<TwatterUser> users = new ArrayList<>();

    public TwatterUserDetailsService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void afterInit() {
        TwatterUser user = TwatterUser.builder()
            .username("user")
            .password(passwordEncoder.encode("user"))
            .role("USER")
            .build();
        users.add(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.stream()
            .filter(u -> username.equals(u.getUsername()))
            .findFirst()
            .map(TwatterUser::asUserDetails)
            .orElseThrow((() -> new UsernameNotFoundException("Bad credentials.")));
    }

}
