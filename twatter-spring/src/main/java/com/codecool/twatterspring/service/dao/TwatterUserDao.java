package com.codecool.twatterspring.service.dao;

import com.codecool.twatterspring.model.AuthDTO;
import com.codecool.twatterspring.model.TwatterUserDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface TwatterUserDao {

    Optional<TwatterUserDTO> findBy(String username);
    boolean exists(String username);
    void save(AuthDTO userDTO);
}
