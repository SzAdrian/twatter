package com.codecool.twatterspring.service;

import com.codecool.twatterspring.model.Tweet;
import com.codecool.twatterspring.model.dto.TrendingHashtagsDTO;
import com.codecool.twatterspring.model.dto.TrendingTweetDTO;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TrendingApiService {

    private final String baseUrl;

    private final RestTemplate template;

    public TrendingApiService(RestTemplateBuilder builder, @Value("$(twatter.trending-api.base-url)") String baseUrl) {
        this.template = builder.build();
        this.baseUrl = baseUrl;
    }

    public HttpStatus postNewTweet(TrendingTweetDTO tweet) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TrendingTweetDTO> request = new HttpEntity<>(tweet, headers);
        ResponseEntity<?> response = template.postForEntity(
                baseUrl,
                request,
                Void.class
        );
        return response.getStatusCode();
    }

    public TrendingHashtagsDTO getTradingHashtagsByTimeInterval(String interval) {
        ResponseEntity<TrendingHashtagsDTO> response = template.getForEntity(
                baseUrl+ "/" + interval,
                TrendingHashtagsDTO.class
        );
        return response.getBody();
    }

    public Long[] getTweetIDsByTrendingHashtag(String hashtag) {
        ResponseEntity<Long[]>response = template.getForEntity(
                baseUrl + "/" + "hashtag",
                Long[].class
        );
        return response.getBody();
    }
}
