package com.codecool.twatterspring.service.dao.mem;

import com.codecool.twatterspring.model.AuthDTO;
import com.codecool.twatterspring.model.TwatterUserDTO;
import com.codecool.twatterspring.service.dao.TwatterUserDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Profile("development & no_db")
@Qualifier("twatterUserDao")
public class TwatterUserDaoMem implements TwatterUserDao {

    private final List<TwatterUserDTO> users = new ArrayList<>();
    private final PasswordEncoder passwordEncoder;

    public TwatterUserDaoMem(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<TwatterUserDTO> findBy(String username) {
        return users.stream().filter(u -> username.equals(u.getUsername())).findFirst();
    }

    @Override
    public boolean exists(String username) {
        return users.stream().anyMatch(u -> username.equals(u.getUsername()));
    }

    @Override
    public void save(AuthDTO userDTO) {
        users.add(createUser(userDTO.getUsername(), userDTO.getPassword(), "USER"));
    }

    private TwatterUserDTO createUser(String username, String password, String... roles) {
        return TwatterUserDTO.builder()
            .username(username)
            .password(passwordEncoder.encode(password))
            .roles(Arrays.asList(roles))
            .build();
    }

    @PostConstruct
    void afterInit() {
        users.add(createUser("user", "user", "USER"));
    }
}
