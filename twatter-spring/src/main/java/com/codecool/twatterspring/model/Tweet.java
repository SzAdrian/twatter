package com.codecool.twatterspring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

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

    @NaturalId
    private Long userId;

    private String content;

    @Column(nullable = false)
    private LocalDateTime date;

}
