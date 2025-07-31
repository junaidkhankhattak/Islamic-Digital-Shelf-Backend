package com.fyp.islamic_digital_shelf.order.bean;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class OrderView {
    private Long id;
    private String customerName;
    private int quantity;
    private String address;
    private String email;
    private String phone;
    private LocalDateTime orderDate;
}

