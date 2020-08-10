package com.codecool.twatterspring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrendingHashtagsDTO {
    private String timeFilter;
    private Hashtag[] trendingHashtags;
}
