package com.codecool.twatterspring.controller;

import com.codecool.twatterspring.model.dto.TimelineTweetDTO;
import com.codecool.twatterspring.service.TimelineService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/timeline")
public class TimelineController {

    private final TimelineService timelineService;

    @GetMapping("/user/{id}")
    public List<TimelineTweetDTO> userTimeline(@PathVariable("id") Long userId){
        return this.timelineService.getUserTimeline(userId);
    }

    @GetMapping("/home/{id}")
    public List<TimelineTweetDTO> homeTimeline(@PathVariable("id") Long userId){
        return this.timelineService.getHomeTimeline(userId);
    }


}
