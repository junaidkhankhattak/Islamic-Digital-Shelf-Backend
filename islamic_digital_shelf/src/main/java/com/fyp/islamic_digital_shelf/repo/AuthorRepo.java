package com.fyp.islamic_digital_shelf.repo;

import com.fyp.islamic_digital_shelf.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author,Long> {
}
