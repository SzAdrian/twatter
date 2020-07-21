package com.codecool.twatterspring.controller;

import com.codecool.twatterspring.model.TimelineTweetDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TimelineController {
    @GetMapping("/users/{id}/user-timeline")
    public List<TimelineTweetDTO> userTimeline(){
        return new ArrayList<>();
    }
}
