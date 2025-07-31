package com.fyp.islamic_digital_shelf.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="files-info")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String fileType;  // e.g., pdf, epub, docx, etc.

    @Column(nullable = false)
    private String filePath;  // Path to the file on the server

    @Column
    private Long fileSize;  // File size in bytes

    @Column(updatable = false)
    private LocalDateTime uploadedAt;

    @PrePersist
    protected void onUpload() {
        this.uploadedAt = LocalDateTime.now();
    }
}
