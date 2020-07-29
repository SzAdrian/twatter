package com.codecool.twatterspring.service;

import com.codecool.twatterspring.model.TwatterUser;
import com.codecool.twatterspring.redis.TimelineRepository;
import com.codecool.twatterspring.repository.TwatterUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
@Import(UserService.class)
class UserServiceIntegrationTest {

    @Autowired
    private TwatterUserRepository users;

    @Autowired
    private UserService userService;

    @MockBean
    private TimelineRepository timelineRepository;

    @BeforeEach
    public void init() {
        TwatterUser user1 = users.save(TwatterUser.builder()
                .name("elon")
                .password("password")
                .registrationDate(LocalDateTime.now())
                .email("elon@musk.com")
                .build()
        );

        TwatterUser user2 = users.save(
                TwatterUser.builder()
                        .name("donald")
                        .password("trumply")
                        .registrationDate(LocalDateTime.now())
                        .email("donald@trump.com")
                        .build()
        );

        TwatterUser user3 = users.save(
                TwatterUser.builder()
                        .name("gergo")
                        .password("gergo")
                        .registrationDate(LocalDateTime.now())
                        .email("gergo@kovacs.com")
                        .followees(new ArrayList<>(Arrays.asList(user1, user2)))
                        .build()
        );

        TwatterUser user4 = users.save(
                TwatterUser.builder()
                        .name("teszt")
                        .password("teszt")
                        .registrationDate(LocalDateTime.now())
                        .email("teszt@elek.com")
                        .followees(new ArrayList<>(Arrays.asList(user1, user3)))
                        .build()
        );

    }

    @Test
    public void testFollowUser() {
        userService.followUser(3L, 4L);
        assertThat(users.getFolloweesByUserId(3L)).hasSize(3);
    }



}