package com.fyp.islamic_digital_shelf.repo;

import com.fyp.islamic_digital_shelf.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {
}
