package com.brown.user_auth_api.dto;

import lombok.Data;

@Data
public class UserRegistrationDto {
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String phoneNumber;
    private String address;
    private String password;

}
