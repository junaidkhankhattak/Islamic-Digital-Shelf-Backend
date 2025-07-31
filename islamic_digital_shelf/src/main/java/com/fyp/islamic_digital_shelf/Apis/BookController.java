package com.fyp.islamic_digital_shelf.Apis;

import com.fyp.islamic_digital_shelf.book.bean.BookRequest;
import com.fyp.islamic_digital_shelf.book.bean.BookView;
import com.fyp.islamic_digital_shelf.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public ResponseEntity<BookView> createBook(@RequestPart("request") BookRequest request, @RequestPart("file") MultipartFile file) {
        request.setFile(file);
        return ResponseEntity.ok(bookService.createBook(request));
    }

    @GetMapping
    public ResponseEntity<List<BookView>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookView> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookView> updateBook(@PathVariable Long id, @RequestPart("request") BookRequest request, @RequestPart("file") MultipartFile file) {
        request.setFile(file);
        return ResponseEntity.ok(bookService.updateBook(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.deleteBook(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookView>> searchBook(@RequestParam String name) {
        return ResponseEntity.ok(bookService.searchBook(name));
    }
}