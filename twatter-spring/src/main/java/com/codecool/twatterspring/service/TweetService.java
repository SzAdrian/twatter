package com.codecool.twatterspring.service;

import com.codecool.twatterspring.model.Tweet;
import com.codecool.twatterspring.model.dto.IncomingTweetDTO;
import com.codecool.twatterspring.model.dto.OutgoingTweetDTO;
import com.codecool.twatterspring.repository.TweetRepositorty;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@RequiredArgsConstructor
public class TweetService {

    private final TweetRepositorty tweets;

    public OutgoingTweetDTO saveNewTweet(IncomingTweetDTO dto) {
        Tweet tweet = Tweet.builder()
                           .userId(dto.getUserId())
                           .content(dto.getContent())
                           .date(LocalDateTime.now())
                           .build();

        tweet = tweets.save(tweet);

        return OutgoingTweetDTO.builder()
                               .id(tweet.getId())
                               .postedAt(Long.toString(tweet.getDate().toEpochSecond(ZoneOffset.UTC)))
                               .build();
    }
}
