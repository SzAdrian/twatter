package com.codecool.twatterspring.model.dto;

import com.codecool.twatterspring.model.Tweet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZoneOffset;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimelineTweetDTO {
    private Long id;
    private String content;
    private Long userId;
    private String username;
    private String postedAt;

    public TimelineTweetDTO fromEntity(Tweet tweet, String username) {
        return tweet == null ? null : TimelineTweetDTO.builder()
                .id(tweet.getId())
                .content(tweet.getContent())
                .userId(tweet.getUserId())
                .username(username)
                .postedAt(Long.toString(tweet.getDate().toEpochSecond(ZoneOffset.UTC)))
                .build();
    }
}
