package com.codecool.twatterspring.controller;

import com.codecool.twatterspring.model.dto.TrendingHashtagsDTO;
import com.codecool.twatterspring.service.TrendingApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trends")
@RequiredArgsConstructor
public class TrendController {

    private final TrendingApiService trends;

    @GetMapping("/{interval}")
    public ResponseEntity<TrendingHashtagsDTO> getTrendingHashtagsBy(@PathVariable String interval) {
        return ResponseEntity.ok(trends.getTradingHashtagsByTimeInterval(interval));
    }
}