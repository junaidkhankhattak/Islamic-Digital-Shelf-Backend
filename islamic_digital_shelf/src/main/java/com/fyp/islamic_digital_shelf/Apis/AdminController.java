package com.fyp.islamic_digital_shelf.Apis;


import com.fyp.islamic_digital_shelf.book.bean.BookRequest;
import com.fyp.islamic_digital_shelf.model.Book;
import com.fyp.islamic_digital_shelf.model.User;
import com.fyp.islamic_digital_shelf.services.BookService;
import com.fyp.islamic_digital_shelf.services.UserService;
import com.fyp.islamic_digital_shelf.user.bean.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    private final BookService bookService;
    private final UserService userService;

    @Autowired
    public AdminController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    // ✅ Add a new book
    @PostMapping("/books")
    public ResponseEntity<String> addBook(@RequestBody BookRequest book, @RequestParam Long adminId) {
        User admin = userService.getRawUserById(adminId);
        if (admin.getRole().name().equals("ADMIN")) {
            bookService.createBook(book);
            return ResponseEntity.ok("Book added successfully");
        } else {
            return ResponseEntity.status(403).body("Access Denied: Only admin can add books");
        }
    }

    // ✅ Get all users
    @GetMapping("/users")
    public ResponseEntity<List<UserView>> getAllUsers(@RequestParam Long adminId) {
        User admin = userService.getRawUserById(adminId);
        if (admin.getRole().name().equals("ADMIN")) {
            return ResponseEntity.ok(userService.getAllUser());
        } else {
            return ResponseEntity.status(403).build();
        }
    }

    // ✅ Delete a user
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id, @RequestParam Long adminId) {
        User admin = userService.getRawUserById(adminId);
        if (admin.getRole().name().equals("ADMIN")) {
            return ResponseEntity.ok(userService.deleteUser(id));
        } else {
            return ResponseEntity.status(403).body("Only admin can delete users");
        }
    }
}
