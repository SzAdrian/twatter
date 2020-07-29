package com.codecool.twatterspring.service;

import com.codecool.twatterspring.model.dto.TwatterUserProfileDTO;
import com.codecool.twatterspring.repository.TwatterUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final TwatterUserRepository users;

    public TwatterUserProfileDTO getUserProfileBy(Long userId) {
        return users.findById(userId)
                .map(TwatterUserProfileDTO::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("The given userId does not exist!"));
    }
}
