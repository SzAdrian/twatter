package com.codecool.twatterspring.repository;

import com.codecool.twatterspring.model.TwatterUser;
import com.codecool.twatterspring.redis.TimelineRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class TwatterUserRepositoryTest {


    @Autowired
    private TwatterUserRepository users;

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
                        .followees(List.of(user1, user2))
                        .build()
        );

        TwatterUser user4 = users.save(
                TwatterUser.builder()
                        .name("teszt")
                        .password("teszt")
                        .registrationDate(LocalDateTime.now())
                        .email("teszt@elek.com")
                        .followees(List.of(user1, user3))
                        .build()
        );

    }

    @Test
    public void initTest() {
        assertThat(users).isNotNull();
        assertThat(users.findAll()).hasSize(4);
    }

    @Test
    public void testFindByName() {
        TwatterUser user = users.findByName("elon").orElse(new TwatterUser());
        assertThat(user.getId()).isEqualTo(1L);
    }








}