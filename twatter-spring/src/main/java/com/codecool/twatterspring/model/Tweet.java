package com.codecool.twatterspring.model;

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

}
