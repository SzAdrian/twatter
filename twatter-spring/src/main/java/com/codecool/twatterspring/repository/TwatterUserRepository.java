package com.codecool.twatterspring.repository;

import com.codecool.twatterspring.model.TwatterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TwatterUserRepository extends JpaRepository<TwatterUser, Long> {

    @Query("SELECT u.name FROM TwatterUser u WHERE u.id = :userId")
    String getUsernameByUserId(@Param("userId") Long userId);

    @Query("SELECT u.followees FROM TwatterUser u WHERE u.id = :userId")
    List<TwatterUser> getFolloweesByUserId(@Param("userId") Long userId);
}
