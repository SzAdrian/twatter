package com.codecool.twatterspring.service;

import com.codecool.twatterspring.model.dto.TrendingHashtagsDTO;
import com.codecool.twatterspring.model.dto.TrendingTweetDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class TrendingApiService {

    private final String baseUrl;

    private final RestTemplate template;

    public TrendingApiService(RestTemplateBuilder builder, @Value("${twatter.trending-api.base-url}") String baseUrl) {
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
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.ALL));
        HttpEntity<String> request = new HttpEntity<>(null, headers);
        System.out.println(request.toString());
        ResponseEntity<TrendingHashtagsDTO> response = template.exchange(
                baseUrl + "/" + interval,
                HttpMethod.GET,
                request,
                TrendingHashtagsDTO.class
        );
        return response.getBody();
    }

    public Long[] getTweetIDsByTrendingHashtag(String hashtag) {
        ResponseEntity<Long[]>response = template.getForEntity(
                baseUrl + "/" + hashtag,
                Long[].class
        );
        return response.getBody();
    }
}
