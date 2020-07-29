package com.codecool.twatterspring.controller;

import com.codecool.twatterspring.model.dto.IncomingTweetDTO;
import com.codecool.twatterspring.model.dto.OutgoingTweetDTO;
import com.codecool.twatterspring.redis.TimelineRepository;
import com.codecool.twatterspring.security.service.JwtService;
import com.codecool.twatterspring.service.TweetService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TweetController.class)
@ActiveProfiles("test")
class TweetControllerTest {

    private static final String urlPrefix = "/api/tweets";

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TweetService tweetService;
    
    @MockBean
    TimelineRepository timelineRepository;
    
    @MockBean
    JwtService jwtService;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void whenNewTweetArrivesInCorrectFormat_ThenReturnsOutgoingTweet_WithStatusOK() throws Exception {
        IncomingTweetDTO incoming = IncomingTweetDTO.builder()
            .content("content")
            .userId(1L)
            .build();
        OutgoingTweetDTO outgoing = OutgoingTweetDTO.builder()
            .id(1L)
            .postedAt(LocalDateTime.now().toString())
            .build();
        when(tweetService.saveNewTweet(incoming)).thenReturn(outgoing);
        
        mockMvc
            .perform(post(urlPrefix)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(incoming)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").exists())
            .andExpect(jsonPath("$.postedAt").exists());
    }
}