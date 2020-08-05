package com.codecool.twatterspring.redis;

import com.codecool.twatterspring.model.dto.TimelineTweetDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
@RedisHash("Timeline")
public class Timeline implements Serializable {

    @Id
    Long userId;
    List<TimelineTweetDTO> homeTweetDTOS;
    List<TimelineTweetDTO> userTweetDTOS;

}
