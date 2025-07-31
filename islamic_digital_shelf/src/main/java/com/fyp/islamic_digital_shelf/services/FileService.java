package com.fyp.islamic_digital_shelf.services;

import com.fyp.islamic_digital_shelf.model.FileEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface FileService {
    /**
     * Save the uploaded file to the server and persist its metadata in the database.
     *
     * @param file the uploaded file
     * @return the saved FileEntity
     * @throws IOException if an error occurs during file storage
     */
    FileEntity saveFile(MultipartFile file) throws IOException;

    /**
     * Retrieve a file by its ID.
     *
     * @param id the ID of the file
     * @return an Optional containing the FileEntity if found, or empty if not found
     */
    Optional<FileEntity> getFileById(Long id);
}
