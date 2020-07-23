package com.codecool.twatterspring.service.dao;

import com.codecool.twatterspring.model.AuthDTO;
import com.codecool.twatterspring.model.TwatterUser;
import com.codecool.twatterspring.model.TwatterUserDTO;
import com.codecool.twatterspring.repository.TwatterUserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Profile("!no_db")
public class TwatterUserDaoDb implements TwatterUserDao {

    private final TwatterUserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public TwatterUserDaoDb(TwatterUserRepository repository,
                            PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<TwatterUserDTO> findBy(String username) {
        return repository.findByName(username).map(TwatterUserDTO::fromEntity);
    }

    @Override
    public boolean exists(String username) {
        return repository.findByName(username).isPresent();
    }

    @Override
    public void save(AuthDTO userDTO) {
        TwatterUser user = TwatterUser.builder()
            .name(userDTO.getUsername())
            .email(userDTO.getEmail())
            .password(passwordEncoder.encode(userDTO.getPassword()))
            .registrationDate(LocalDateTime.now())
            .build();
        repository.save(user);
    }
}
