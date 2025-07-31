package com.fyp.islamic_digital_shelf.model;

import com.fyp.islamic_digital_shelf.user.bean.UserRequestParam;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name",nullable = false)
    private String name;
    @Column(name = "user_email",nullable = false, unique = true)
    private String email;
    @Column(name = "user_password",nullable = false)
    private String password;
    @Column(name = "user_phone_number",nullable = false)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role; // ADMIN,MEMBER

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // The initModel method to initialize the entity fields from UserRequestParam
    public void initModel(UserRequestParam userRequestParam) {
        if (userRequestParam != null) {
            if (userRequestParam.getName() != null) {
                this.name = userRequestParam.getName();
            }
            if (userRequestParam.getEmail() != null) {
                this.email = userRequestParam.getEmail();
            }
            if (userRequestParam.getPhoneNumber() != null) {
                this.phoneNumber = userRequestParam.getPhoneNumber();
            }
            if (userRequestParam.getPassword()!=null){
                this.password=userRequestParam.getPassword();
            }

        }
    }
}

