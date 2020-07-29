package com.codecool.twatterspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {

    @GetMapping("/{userId}")
    public ResponseEntity<?> getProfile(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @PostMapping("/{userId}/followees")
    public ResponseEntity<?> followUser(@RequestBody Long followeeId, @PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}
