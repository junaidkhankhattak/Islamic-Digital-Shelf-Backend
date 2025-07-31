package com.fyp.islamic_digital_shelf.user.bean;

import com.fyp.islamic_digital_shelf.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserView {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String role;
    public UserView(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.role = user.getRole().name(); // Convert enum to string
    }
}
