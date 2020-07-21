package com.codecool.twatterspring.service;

import com.codecool.twatterspring.model.TimelineTweetDTO;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class TimelineService {

    private final TweetService tweetService;

    public List<TimelineTweetDTO> getUserTimeline(Long userId) {
        return tweetService.getAllByUserId(userId);
    }
}
