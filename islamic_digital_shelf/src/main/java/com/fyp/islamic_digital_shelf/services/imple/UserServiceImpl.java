package com.fyp.islamic_digital_shelf.services.imple;

import com.fyp.islamic_digital_shelf.model.Role;
import com.fyp.islamic_digital_shelf.repo.UserRepo;
import com.fyp.islamic_digital_shelf.model.User;
import com.fyp.islamic_digital_shelf.user.bean.LoginResponse;
import com.fyp.islamic_digital_shelf.user.bean.UserRequestParam;
import com.fyp.islamic_digital_shelf.user.bean.UserView;
import com.fyp.islamic_digital_shelf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepository;

    @Autowired
    public UserServiceImpl(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    // Register a new user
    @Override
    public UserView register(UserRequestParam request) {
        // Create a new User entity and initialize from request
        User user = new User();
        user.initModel(request);
        user.setRole(Role.MEMBER);

        // Save the user to the repository
        User savedUser = userRepository.save(user);

        // Return a UserView with saved user data
        return new UserView(savedUser);
    }

    // User login
    @Override
    public LoginResponse login(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            if (password.equals(user.get().getPassword())) {
                User u = user.get();
                return new LoginResponse(
                        u.getId(),
                        u.getName(),
                        u.getEmail(),
                        u.getRole().name()
                );
            } else {
                throw new RuntimeException("Invalid password!");
            }
        } else {
            throw new RuntimeException("User not found!");
        }
    }



    // User forgot password (reset password)
    @Override
    public String forgotPassword(String email, String newPassword) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            User u = user.get();
            u.setPassword(newPassword); // Update password
            userRepository.save(u); // Save the updated user
            return "Password updated successfully!";
        }
        return "User not found with the provided email";
    }

    // Get all users
    @Override
    public List<UserView> getAllUser() {
        // Get all users and map to UserView
        return userRepository.findAll().stream()
                .map(UserView::new)
                .collect(Collectors.toList());
    }

    // Get a user by ID
    @Override
    public UserView getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new UserView(user);
    }

    // Update user details
    @Override
    public UserView updateUser(Long id, UserRequestParam request) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.initModel(request); // Initialize fields with new request data
            userRepository.save(user); // Save updated user data
            return new UserView(user);
        }
        throw new RuntimeException("User not found");
    }

    // Delete a user by ID
    @Override
    public String deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User deleted successfully";
        }
        return "User not found";
    }

    @Override
    public User getRawUserById(Long adminId) {
        return userRepository.findById(adminId).orElseThrow(() -> new RuntimeException("User not found"));
    }

}