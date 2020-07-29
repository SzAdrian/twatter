package com.codecool.twatterspring.service;

import com.codecool.twatterspring.repository.TwatterUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final TwatterUserRepository users;
}
