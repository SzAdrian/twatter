package com.codecool.twatterspring.redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimelineRepository extends CrudRepository<Timeline, Long> {
}
