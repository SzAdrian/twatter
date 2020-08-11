package com.codecool.twatterspring.controller;

import com.codecool.twatterspring.model.dto.TwatterUserProfileDTO;
import com.codecool.twatterspring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<TwatterUserProfileDTO> getProfile(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserProfileBy(userId));
    }

    @PostMapping("/{userId}/followees")
    public ResponseEntity<?> followUser(@RequestBody Long followeeId, @PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @DeleteMapping("/{userId}/followees/{followeeId}")
    public ResponseEntity<?> unfollowUser(@PathVariable Long userId, @PathVariable Long followeeId) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}
