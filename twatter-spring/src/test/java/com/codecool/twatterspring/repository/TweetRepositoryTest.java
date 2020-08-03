package com.codecool.twatterspring.repository;

import com.codecool.twatterspring.model.TwatterUser;
import com.codecool.twatterspring.model.Tweet;
import com.codecool.twatterspring.redis.TimelineRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TweetRepositoryTest {

    @Autowired
    private TweetRepository tweets;

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
        System.out.println(user1.getId());

        TwatterUser user2 = users.save(
                TwatterUser.builder()
                        .name("donald")
                        .password("trumply")
                        .registrationDate(LocalDateTime.now())
                        .email("donald@trump.com")
                        .build()
        );
        System.out.println(user2.getId());

        TwatterUser user3 = users.save(
                TwatterUser.builder()
                        .name("gergo")
                        .password("gergo")
                        .registrationDate(LocalDateTime.now())
                        .email("gergo@kovacs.com")
                        .followees(List.of(user1, user2))
                        .build()
        );
        System.out.println(user3.getId());

        TwatterUser user4 = users.save(
                TwatterUser.builder()
                        .name("teszt")
                        .password("teszt")
                        .registrationDate(LocalDateTime.now())
                        .email("teszt@elek.com")
                        .followees(List.of(user1, user3))
                        .build()
        );

        System.out.println(user4.getId());
    }

    @Test
    public void initTest() {
        assertThat(users).isNotNull();
        assertThat(tweets).isNotNull();
        assertThat(users.findAll()).hasSize(4);
    }

    @Test
    public void saveNewTweetTest() {
        Tweet tweet = tweets.save(
                Tweet.builder()
                    .content("Test tweet")
                    .date(LocalDateTime.now())
                    .userId(1L)
                    .build()
        );
        assertThat(tweets.findAll()).hasSize(1).containsExactly(tweet);
    }

    @Test
    public void getAllTweetsOfGivenUserTest() {
        Tweet tweet1 = tweets.save(
                Tweet.builder()
                        .content("Test tweet")
                        .date(LocalDateTime.now())
                        .userId(1L)
                        .build()
        );

        Tweet tweet2 = tweets.save(
                Tweet.builder()
                        .content("Test tweet2")
                        .date(LocalDateTime.now())
                        .userId(1L)
                        .build()
        );

        Tweet tweet3 = tweets.save(
                Tweet.builder()
                        .content("Test tweet3")
                        .date(LocalDateTime.now())
                        .userId(2L)
                        .build()
        );

        assertThat(tweets.findAllByUserId(1L)).hasSize(2).containsExactlyInAnyOrder(tweet1, tweet2);
        assertThat(tweets.findAllByUserId(2L)).hasSize(1).containsExactlyInAnyOrder(tweet3);
        assertThat(tweets.findAllByUserId(3L)).hasSize(0);
        assertThat(tweets.findAllByUserId(4L)).hasSize(0);

    }

    @Test
    public void getAllTweetsOfUsersFolloweesTest() {
        Tweet tweet1 = tweets.save(
                Tweet.builder()
                        .content("Test tweet")
                        .date(LocalDateTime.now())
                        .userId(1L)
                        .build()
        );

        Tweet tweet2 = tweets.save(
                Tweet.builder()
                        .content("Test tweet2")
                        .date(LocalDateTime.now())
                        .userId(1L)
                        .build()
        );

        Tweet tweet3 = tweets.save(
                Tweet.builder()
                        .content("Test tweet3")
                        .date(LocalDateTime.now())
                        .userId(2L)
                        .build()
        );
        Tweet tweet4 = tweets.save(
                Tweet.builder()
                        .content("Test tweet4")
                        .date(LocalDateTime.now())
                        .userId(2L)
                        .build()
        );

        List<Long> followeeIDs1 = List.of(1L, 2L, 3L, 4L);
        List<Long> followeeIDs2 = List.of(1L, 3L);
        List<Long> followeeIDs3 = List.of(4L, 3L);

        assertThat(tweets.findLimitedNumberOfTweetsByFolloweeIds(followeeIDs1))
                .hasSize(4)
                .containsExactlyInAnyOrder(tweet1, tweet2, tweet3, tweet4);
        assertThat(tweets.findLimitedNumberOfTweetsByFolloweeIds(followeeIDs2))
                .hasSize(2)
                .containsExactlyInAnyOrder(tweet1, tweet2);
        assertThat(tweets.findLimitedNumberOfTweetsByFolloweeIds(followeeIDs3))
                .hasSize(0);
    }
}
