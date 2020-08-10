package com.codecool.twatterspring.repository;

import com.codecool.twatterspring.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    List<Tweet> findAllByUserId(Long id);

    @Query("SELECT t FROM Tweet t WHERE t.userId IN :followeeIds ORDER BY t.date DESC")
    List<Tweet> findLimitedNumberOfTweetsByFolloweeIds(@Param("followeeIds") List<Long> followeeIds);
}
