package com.codecool.twatterspring.model.dto;

import com.codecool.twatterspring.model.TwatterUser;
import com.codecool.twatterspring.model.TwatterUserDTO;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Singular;

import java.time.LocalDateTime;
import java.util.List;

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
