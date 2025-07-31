package com.fyp.islamic_digital_shelf.Apis;

import com.fyp.islamic_digital_shelf.auther.bean.AuthorRequestParam;
import com.fyp.islamic_digital_shelf.auther.bean.AuthorView;
import com.fyp.islamic_digital_shelf.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/create")
    public ResponseEntity<AuthorView> createAuthor(@RequestBody AuthorRequestParam request) {
        return ResponseEntity.ok(authorService.saveAuthor(request));
    }

    @GetMapping
    public ResponseEntity<List<AuthorView>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthor());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorView> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorView> updateAuthor(@PathVariable Long id, @RequestBody AuthorRequestParam request) {
        return ResponseEntity.ok(authorService.updateAuthor(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.deleteAuthor(id));
    }


}
