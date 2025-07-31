package com.fyp.islamic_digital_shelf.user.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private Long id;
    private String name;
    private String email;
    private String role;
}

