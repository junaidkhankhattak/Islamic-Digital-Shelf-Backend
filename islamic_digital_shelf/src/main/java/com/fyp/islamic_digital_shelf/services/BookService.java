package com.fyp.islamic_digital_shelf.services;

import com.fyp.islamic_digital_shelf.book.bean.BookRequest;
import com.fyp.islamic_digital_shelf.book.bean.BookView;

import java.util.List;

public interface BookService {
    BookView createBook(BookRequest request);
    List<BookView> getAllBooks();
    BookView getBookById(Long id);
    BookView updateBook(Long id,BookRequest name);
    String deleteBook(Long id);
    List<BookView> searchBook(String name);
}
