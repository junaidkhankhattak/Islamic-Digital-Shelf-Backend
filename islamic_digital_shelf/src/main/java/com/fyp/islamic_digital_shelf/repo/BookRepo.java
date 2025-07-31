package com.fyp.islamic_digital_shelf.repo;

import com.fyp.islamic_digital_shelf.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
//    List<Book> findByTitleContainingIgnoreCase(String title);
//
//    List<Book> findByAuthor_NameContainingIgnoreCase(String author);
//
//    List<Book> findByCategory_NameContainingIgnoreCase(String category);
List<Book> findByTitleContaining(String name);
}
