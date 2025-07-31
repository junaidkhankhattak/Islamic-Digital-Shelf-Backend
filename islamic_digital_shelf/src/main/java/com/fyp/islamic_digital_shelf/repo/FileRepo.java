package com.fyp.islamic_digital_shelf.repo;

import com.fyp.islamic_digital_shelf.model.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileRepo extends JpaRepository<FileEntity,Long> {
    Optional<FileEntity> findByFileName(String fileName);

}
