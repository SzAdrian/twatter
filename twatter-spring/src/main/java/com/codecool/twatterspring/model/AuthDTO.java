package com.codecool.twatterspring.model;

import lombok.Data;

@Data
public class AuthDTO {
    private String username;
    private String email;
    private String password;
}
