package com.fyp.islamic_digital_shelf.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "category_name")
    private String name;
    @Column(name = "description")
    private String description;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    // Constructors, getters, and setters
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
        this.createdDate = LocalDateTime.now(); // Set the created date to the current time
    }

}
