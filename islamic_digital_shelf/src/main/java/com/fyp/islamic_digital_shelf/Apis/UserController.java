package com.fyp.islamic_digital_shelf.Apis;

import com.fyp.islamic_digital_shelf.user.bean.LoginResponse;
import com.fyp.islamic_digital_shelf.user.bean.UserLoginParam;
import com.fyp.islamic_digital_shelf.user.bean.UserRequestParam;
import com.fyp.islamic_digital_shelf.user.bean.UserView;
import com.fyp.islamic_digital_shelf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*@CrossOrigin(origins = "http://localhost:5173/")*/
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserView> register(@RequestBody UserRequestParam request) {
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody UserLoginParam request) {
        return ResponseEntity.ok(userService.login(request.getEmail(), request.getPassword()));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserView>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserView> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserView> updateUser(@PathVariable Long id, @RequestBody UserRequestParam request) {
        return ResponseEntity.ok(userService.updateUser(id, request));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam String email, @RequestParam String newPassword) {
        return ResponseEntity.ok(userService.forgotPassword(email, newPassword));
    }
}