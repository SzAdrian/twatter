package com.codecool.twatterspring.service;

import com.codecool.twatterspring.model.Tweet;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Service
public class TrendingApiService {
    private static final String BASE_URL = "?";

    private final RestTemplate template;

    public TrendingApiService(RestTemplateBuilder builder) {
        this.template = builder.build();
    }
}
