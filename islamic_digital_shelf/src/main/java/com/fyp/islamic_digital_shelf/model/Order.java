package com.fyp.islamic_digital_shelf.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String email;
    private String address;
    private String phone;

    private int quantity;

    private LocalDateTime orderDate;

    private Long bookId;
}

