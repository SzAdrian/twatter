package com.codecool.twatterspring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class TimelineTweetDTO {
    private Long userId;
    private String username;
    private Long id;
    private String content;
    private String postedAt;
}
