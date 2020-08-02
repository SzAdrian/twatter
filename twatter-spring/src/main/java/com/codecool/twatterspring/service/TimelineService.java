package com.codecool.twatterspring.service;

import com.codecool.twatterspring.model.dto.TimelineTweetDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TimelineService {

    private final TweetService tweetService;

    public List<TimelineTweetDTO> getUserTimeline(Long userId) {
        return tweetService.provideTweetsForUserTimelineBy(userId);
    }

    public List<TimelineTweetDTO> getHomeTimeline(Long userId) {
        return tweetService.provideTweetsForHomeTimelineBy(userId);
    }
}