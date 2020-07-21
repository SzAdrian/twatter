package com.codecool.twatterspring.controller;

import com.codecool.twatterspring.model.TimelineTweetDTO;
import com.codecool.twatterspring.service.TimelineService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
public class TimelineController {

    private final TimelineService timelineService;

    @GetMapping("/users/{id}/user-timeline")
    public List<TimelineTweetDTO> userTimeline(@PathVariable("id") Long user_id){
        return new ArrayList<>();
    }


}
