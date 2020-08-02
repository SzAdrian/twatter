package com.codecool.twatterspring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}