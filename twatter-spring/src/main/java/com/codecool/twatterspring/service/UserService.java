package com.codecool.twatterspring.service;

import com.codecool.twatterspring.model.TwatterUser;
import com.codecool.twatterspring.model.dto.TwatterUserProfileDTO;
import com.codecool.twatterspring.repository.TwatterUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final TwatterUserRepository users;

    public TwatterUserProfileDTO getUserProfileBy(Long userId) {
        return users.findById(userId)
                .map(TwatterUserProfileDTO::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("The given userId does not exist!"));
    }
    @Transactional
    public void followUser(Long userId, Long followeeId) {
        TwatterUser user = users.findById(userId)
                                .orElseThrow(() -> new EntityNotFoundException("The given userId does not exist!"));

        TwatterUser followee = users.findById(followeeId)
                                .orElseThrow(() -> new EntityNotFoundException("The given followeeId does not exist!"));

        List<TwatterUser> followees = user.getFollowees();
        followees.add((followee));

        users.save(user);
    }

    @Transactional
    public void unfollowUser(Long userId, Long followeeId) {
        TwatterUser user = users.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("The given userId does not exist!"));

        user.getFollowees().removeIf((followee) -> followee.getId().equals(followeeId));
        users.save(user);


    }
}
