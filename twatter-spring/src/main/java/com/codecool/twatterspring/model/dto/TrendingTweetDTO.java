package com.codecool.twatterspring.model.dto;

import com.codecool.twatterspring.model.Tweet;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZoneOffset;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonSerialize
public class TrendingTweetDTO {
    private String id;
    private String content;
    @JsonProperty("posted_at")
    private String postedAt;

    public static TrendingTweetDTO fromEntity(Tweet tweet) {
        return tweet == null ? null : TrendingTweetDTO.builder()
                .id(Long.toString(tweet.getId()))
                .content(tweet.getContent())
                .postedAt(Long.toString(tweet.getDate().toEpochSecond(ZoneOffset.UTC)))
                .build();
    }
}
