package com.brown.user_auth_api.dto;

import lombok.Data;

@Data
public class UserRegistrationDto {
    private Long id;
    private String username;
    private String password;
    private String email;

}
