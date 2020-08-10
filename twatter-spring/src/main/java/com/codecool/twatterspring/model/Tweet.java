package com.codecool.twatterspring.model;

import com.codecool.twatterspring.model.dto.IncomingTweetDTO;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Tweet {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private String content;

    @Column(nullable = false)
    @EqualsAndHashCode.Exclude
    private LocalDateTime date;

    public static Tweet fromDTO(IncomingTweetDTO dto) {
        return dto == null ? null : Tweet.builder()
                .userId(dto.getUserId())
                .content(dto.getContent())
                .date(LocalDateTime.now())
                .build();
    }

}
