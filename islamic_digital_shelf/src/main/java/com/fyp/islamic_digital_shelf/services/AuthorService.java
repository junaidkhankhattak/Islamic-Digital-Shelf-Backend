package com.fyp.islamic_digital_shelf.services;

import com.fyp.islamic_digital_shelf.auther.bean.AuthorRequestParam;
import com.fyp.islamic_digital_shelf.auther.bean.AuthorView;

import java.util.List;

public interface AuthorService {

    List<AuthorView> getAllAuthor();
    AuthorView getAuthorById(Long id);
    AuthorView updateAuthor(Long id,AuthorRequestParam authorRequestParam);
    AuthorView saveAuthor(AuthorRequestParam authorRequestParam);
    String deleteAuthor(Long id);
}
