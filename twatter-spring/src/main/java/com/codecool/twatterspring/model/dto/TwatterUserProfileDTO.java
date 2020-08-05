package com.codecool.twatterspring.model.dto;

import com.codecool.twatterspring.model.TwatterUser;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class TwatterUserProfileDTO {
    private Long id;
    private String username;
    private String email;
    private LocalDateTime registrationDate;

    public static TwatterUserProfileDTO fromEntity(TwatterUser twatterUser) {
        return TwatterUserProfileDTO.builder()
                .id(twatterUser.getId())
                .username(twatterUser.getName())
                .email(twatterUser.getEmail())
                .registrationDate(twatterUser.getRegistrationDate())
                .build();
    }
}
