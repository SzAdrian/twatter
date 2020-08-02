package com.codecool.twatterspring.service;

import com.codecool.twatterspring.model.TwatterUser;
import com.codecool.twatterspring.model.Tweet;
import com.codecool.twatterspring.model.dto.IncomingTweetDTO;
import com.codecool.twatterspring.model.dto.OutgoingTweetDTO;
import com.codecool.twatterspring.model.dto.TimelineTweetDTO;
import com.codecool.twatterspring.model.dto.TrendingTweetDTO;
import com.codecool.twatterspring.repository.TwatterUserRepository;
import com.codecool.twatterspring.repository.TweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TweetService {

    private final TweetRepository tweets;
    private final TwatterUserRepository users;
    private final TrendingApiService trending;

    public OutgoingTweetDTO handleNewTweet(IncomingTweetDTO dto) {
        Tweet tweet = tweets.save(new Tweet().fromDTO(dto));
        trending.postNewTweet(new TrendingTweetDTO().fromEntity(tweet));

        return new OutgoingTweetDTO().fromEntity(tweet);
    }
    public List<TimelineTweetDTO> provideTweetsForUserTimelineBy(Long userId) {
        List<Tweet> userTweets = tweets.findAllByUserId(userId);
        return userTweets.stream()
                         .map(tweet -> TimelineTweetDTO.builder()
                                           .id(tweet.getId())
                                           .content(tweet.getContent())
                                           .userId(tweet.getUserId())
                                           .username(users.getUsernameByUserId(tweet.getUserId()))
                                           .postedAt(Long.toString(tweet.getDate().toEpochSecond(ZoneOffset.UTC)))
                                           .build())
                         .collect(Collectors.toList());
    }

    public List<TimelineTweetDTO> provideTweetsForHomeTimelineBy(Long userId) {
        List<Long> followeeIds = users.getFolloweesByUserId(userId)
                                      .stream()
                                      .map(TwatterUser::getId)
                                      .collect(Collectors.toList());
        List<Tweet> followeeTweets = tweets.findLimitedNumberOfTweetsByFolloweeIds(followeeIds);

        return followeeTweets.stream()
                             .map(tweet -> TimelineTweetDTO.builder()
                                                .id(tweet.getId())
                                                .content(tweet.getContent())
                                                .userId(tweet.getUserId())
                                                .username(users.getUsernameByUserId(tweet.getUserId()))
                                                .postedAt(Long.toString(tweet.getDate().toEpochSecond(ZoneOffset.UTC)))
                                                .build())
                             .collect(Collectors.toList());
    }
}
