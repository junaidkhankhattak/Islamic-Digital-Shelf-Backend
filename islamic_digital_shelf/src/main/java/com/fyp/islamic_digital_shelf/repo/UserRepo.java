package com.fyp.islamic_digital_shelf.repo;

import com.fyp.islamic_digital_shelf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
//    Optional<User> findByName(String username);
    Optional<User> findByEmail(String email);
}