package com.fyp.islamic_digital_shelf.services.imple;

import com.fyp.islamic_digital_shelf.model.FileEntity;
import com.fyp.islamic_digital_shelf.repo.FileRepo;
import com.fyp.islamic_digital_shelf.services.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    private final String uploadDir = "uploads/";  // Directory for storing uploaded files
    private final FileRepo fileRepository;

    public FileServiceImpl(FileRepo fileRepository) {
        this.fileRepository = fileRepository;
    }


    @Override
    public FileEntity saveFile(MultipartFile file) throws IOException {
        // Ensure the upload directory exists
        Files.createDirectories(Paths.get(uploadDir));

        // Generate a unique file name to avoid conflicts
        String uniqueFileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir + uniqueFileName);

        // Save the file to the server
        Files.write(filePath, file.getBytes());

        // Create and save the FileEntity in the database
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileName(file.getOriginalFilename());
        fileEntity.setFilePath(filePath.toString());
        fileEntity.setFileSize(file.getSize());
        fileEntity.setFileType(file.getContentType());

        return fileRepository.save(fileEntity);
    }

    @Override
    public Optional<FileEntity> getFileById(Long id) {
        return fileRepository.findById(id);
    }
}
