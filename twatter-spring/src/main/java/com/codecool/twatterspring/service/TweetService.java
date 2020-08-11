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

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TweetService {

    private final TweetRepository tweets;
    private final TwatterUserRepository users;
    private final TrendingApiService trending;

    public OutgoingTweetDTO handleNewTweet(IncomingTweetDTO dto) {
        Tweet tweet = tweets.save(Tweet.fromDTO(dto));
        trending.postNewTweet(TrendingTweetDTO.fromEntity(tweet));

        return OutgoingTweetDTO.fromEntity(tweet);
    }
    public List<TimelineTweetDTO> provideTweetsForUserTimelineBy(Long userId) {
        List<Tweet> userTweets = tweets.findAllByUserId(userId);
        return userTweets.stream()
                         .map(tweet -> TimelineTweetDTO.fromEntity(
                                 tweet,
                                 users.getUsernameByUserId(tweet.getUserId()))
                         )
                         .collect(Collectors.toList());
    }

    public List<TimelineTweetDTO> provideTweetsForHomeTimelineBy(Long userId) {
        List<Long> followeeIds = users.getFolloweesByUserId(userId)
                                      .stream()
                                      .map(TwatterUser::getId)
                                      .collect(Collectors.toList());
        List<Tweet> followeeTweets = tweets.findLimitedNumberOfTweetsByFolloweeIds(followeeIds);

        return followeeTweets.stream()
                             .map(tweet -> TimelineTweetDTO.fromEntity(
                                     tweet,
                                     users.getUsernameByUserId(tweet.getUserId()))
                             )
                             .collect(Collectors.toList());
    }
}
