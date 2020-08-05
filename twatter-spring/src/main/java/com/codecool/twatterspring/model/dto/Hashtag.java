package com.codecool.twatterspring.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Hashtag {
    private String hashtag;
    private int count;
}
