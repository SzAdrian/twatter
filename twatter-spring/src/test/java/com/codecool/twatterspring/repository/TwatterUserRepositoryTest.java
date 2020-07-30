package com.codecool.twatterspring.repository;

import com.codecool.twatterspring.model.TwatterUser;
import com.codecool.twatterspring.redis.TimelineRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class TwatterUserRepositoryTest {

    @Autowired
    private TwatterUserRepository users;

    @MockBean
    private TimelineRepository timelineRepository;

    @BeforeEach
    public void init() {
        
        TwatterUser elon = users.save(TwatterUser.builder()
                .name("elon")
                .password("password")
                .registrationDate(LocalDateTime.now())
                .email("elon@musk.com")
                .build()
        );

        TwatterUser trumply = users.save(
                TwatterUser.builder()
                        .name("donald")
                        .password("trumply")
                        .registrationDate(LocalDateTime.now())
                        .email("donald@trump.com")
                        .build()
        );

        TwatterUser gergo = users.save(
                TwatterUser.builder()
                        .name("gergo")
                        .password("gergo")
                        .registrationDate(LocalDateTime.now())
                        .email("gergo@kovacs.com")
                        .followees(List.of(elon, trumply))
                        .build()
        );

        TwatterUser elek = users.save(
                TwatterUser.builder()
                        .name("teszt")
                        .password("teszt")
                        .registrationDate(LocalDateTime.now())
                        .email("teszt@elek.com")
                        .followees(List.of(elon, gergo))
                        .build()
        );
    }


    @Test
    @Order(1)
    public void initTest() {
        assertThat(users).isNotNull();
        assertThat(users.findAll()).hasSize(4);
    }

    @Test
    @Order(2)
    public void testFindByName() {
        TwatterUser user = users.findByName("elon").orElse(new TwatterUser());
        assertThat(user.getId()).isEqualTo(1L);
    }

    @Test
    @Order(3)
    public void testGetUsernameByUserId() {
        assertThat(users.getUsernameByUserId(1L)).isEqualTo("elon");
    }


    @Test
    @Order(4)
    public void testUserHasTwoFollowees() {
        assertThat(users.getFolloweesByUserId(3L)).hasSize(2);
    }






}