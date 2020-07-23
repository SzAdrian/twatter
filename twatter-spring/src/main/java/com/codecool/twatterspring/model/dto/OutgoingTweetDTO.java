package com.codecool.twatterspring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutgoingTweetDTO {
    private Long id;
    private String postedAt;
}
