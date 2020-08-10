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
public class TrendingTweetDTO {
    private Long id;
    private String content;
    private String postedAt;

    public static TrendingTweetDTO fromEntity(Tweet tweet) {
        return tweet == null ? null : TrendingTweetDTO.builder()
                .id(tweet.getId())
                .content(tweet.getContent())
                .postedAt(Long.toString(tweet.getDate().toEpochSecond(ZoneOffset.UTC)))
                .build();
    }
}
