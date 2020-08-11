package com.codecool.twatterspring.controller;

import com.codecool.twatterspring.model.dto.IncomingTweetDTO;
import com.codecool.twatterspring.model.dto.OutgoingTweetDTO;
import com.codecool.twatterspring.service.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tweets")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TweetController {

    private final TweetService tweetService;

    @PostMapping
    public ResponseEntity<OutgoingTweetDTO> add(@RequestBody IncomingTweetDTO dto) {
        return ResponseEntity.ok(tweetService.handleNewTweet(dto));
    }
}
