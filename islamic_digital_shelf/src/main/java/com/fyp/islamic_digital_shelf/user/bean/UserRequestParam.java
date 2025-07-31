package com.fyp.islamic_digital_shelf.user.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class UserRequestParam {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;

}
