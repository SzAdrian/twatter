package com.codecool.twatterspring.service;

import com.codecool.twatterspring.model.Tweet;
import com.codecool.twatterspring.model.dto.TrendingHashtagsDTO;
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

    public HttpStatus postNewTweet(Tweet tweet) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Tweet> request = new HttpEntity<>(tweet, headers);
        ResponseEntity<?> response = template.postForEntity(
                BASE_URL,
                request,
                Void.class
        );
        return response.getStatusCode();
    }

    public TrendingHashtagsDTO getTradingHashtagsByTimeInterval(String interval) {
        ResponseEntity<TrendingHashtagsDTO> response = template.getForEntity(
                BASE_URL+ "/" + interval,
                TrendingHashtagsDTO.class
        );
        return response.getBody();
    }
}
