package com.fyp.islamic_digital_shelf.book.bean;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data
public class BookRequest {
    private String title;
    private String description;
    private String publishedDate;
    private Long authorId;
    private Long categoryId;
    private MultipartFile file;
}
