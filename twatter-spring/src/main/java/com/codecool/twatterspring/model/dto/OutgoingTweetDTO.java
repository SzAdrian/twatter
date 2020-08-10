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
public class OutgoingTweetDTO {
    private Long id;
    private String postedAt;

    public static OutgoingTweetDTO fromEntity(Tweet tweet) {
        return tweet == null ? null : OutgoingTweetDTO.builder()
                .id(tweet.getId())
                .postedAt(Long.toString(tweet.getDate().toEpochSecond(ZoneOffset.UTC)))
                .build();
    }
}
