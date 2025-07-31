package com.fyp.islamic_digital_shelf.category.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CategoryView {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdDate;
}
