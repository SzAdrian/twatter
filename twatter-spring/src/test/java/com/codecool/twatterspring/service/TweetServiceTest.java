package com.codecool.twatterspring.service;

import com.codecool.twatterspring.model.TwatterUser;
import com.codecool.twatterspring.model.Tweet;
import com.codecool.twatterspring.model.dto.IncomingTweetDTO;
import com.codecool.twatterspring.model.dto.OutgoingTweetDTO;
import com.codecool.twatterspring.redis.TimelineRepository;
import com.codecool.twatterspring.repository.TwatterUserRepository;
import com.codecool.twatterspring.repository.TweetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class TweetServiceTest {

    private TweetService service;

    @MockBean
    TweetRepository tweets;
    @MockBean
    TwatterUserRepository users;
    @MockBean
    TrendingApiService trendingApi;

    @MockBean
    private TimelineRepository timelineRepository;

    @BeforeEach
    public void init() {
        service = new TweetService(tweets, users, trendingApi);
    }

    @Test
    public void initTest() {
        assertThat(service).isNotNull();
    }

    @Test
    public void handleNewTweetTest() {

        IncomingTweetDTO incomingTweet1 = IncomingTweetDTO.builder()
                .content("Test tweet")
                .userId(1L)
                .build();

        Tweet tweet1WithoutId = Tweet.builder()
                .content("Test tweet")
                .date(LocalDateTime.now())
                .userId(1L)
                .build();

        Tweet tweet1WithId = Tweet.builder()
                .id(1L)
                .content("Test tweet")
                .date(tweet1WithoutId.getDate())
                .userId(1L)
                .build();

        OutgoingTweetDTO outgoingTweetDTO = OutgoingTweetDTO.builder()
                .id(1L)
                .postedAt(Long.toString(tweet1WithId.getDate().toEpochSecond(ZoneOffset.UTC)))
                .build();

        when(tweets.save(tweet1WithoutId)).thenReturn(tweet1WithId);
        assertThat(service.handleNewTweet(incomingTweet1)).isEqualTo(outgoingTweetDTO);
    }
}
