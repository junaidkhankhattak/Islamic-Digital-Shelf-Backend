package com.fyp.islamic_digital_shelf.book.bean;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class BookView {
    private Long id;
    private String title;
    private String description;
    private String publishedDate;
    private String authorName;
    private String categoryName;
    private String fileUrl;

    public BookView() {

    }
}

