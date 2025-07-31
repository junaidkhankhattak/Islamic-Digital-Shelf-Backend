package com.fyp.islamic_digital_shelf.Apis;

import com.fyp.islamic_digital_shelf.services.FileService;
import com.fyp.islamic_digital_shelf.model.FileEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/api/files")
@Tag(name = "File API", description = "API for uploading and downloading files")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @Operation(summary = "Upload a file")
    @PostMapping("/upload")
    public ResponseEntity<FileEntity> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            FileEntity savedFile = fileService.saveFile(file);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedFile);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

//    @Operation(summary = "Download a file by ID")
//    @GetMapping("/download/{id}")
//    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
//        return fileService.getFileById(id).map(fileType -> {
//            try {
//                Path path = Paths.get(fileType.getFilePath());
//                byte[] data = Files.readAllBytes(path);
//                return ResponseEntity.ok()
//                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileType.getFileName() + "\"")
//                        .body(data);
//            } catch (IOException e) {
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//            }
//        }).orElse(ResponseEntity.notFound().build());
//    }
}
