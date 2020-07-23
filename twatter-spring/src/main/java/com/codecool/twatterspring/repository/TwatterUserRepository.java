package com.codecool.twatterspring.repository;

import com.codecool.twatterspring.model.TwatterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TwatterUserRepository extends JpaRepository<TwatterUser, Long> {

    @Query("SELECT u.name FROM TwatterUser u WHERE u.id = :userId")

    String getUsernameByUserId(@Param("userId") Long userId);
}
