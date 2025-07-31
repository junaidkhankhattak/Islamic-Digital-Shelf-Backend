package com.fyp.islamic_digital_shelf.order.bean;


import lombok.Data;

@Data
public class OrderRequest {
    private String customerName;
    private String email;
    private String address;
    private String phone;
    private int quantity;
    private Long bookId;
}
