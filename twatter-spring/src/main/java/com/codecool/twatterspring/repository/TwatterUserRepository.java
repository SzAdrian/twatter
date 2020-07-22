package com.codecool.twatterspring.repository;

import com.codecool.twatterspring.model.TwatterUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TwatterUserRepository extends CrudRepository<TwatterUser, Long> {
    Optional<TwatterUser> findByName(String username);
}
