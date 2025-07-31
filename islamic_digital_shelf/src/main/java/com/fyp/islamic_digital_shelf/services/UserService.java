package com.fyp.islamic_digital_shelf.services;

import com.fyp.islamic_digital_shelf.model.User;
import com.fyp.islamic_digital_shelf.user.bean.LoginResponse;
import com.fyp.islamic_digital_shelf.user.bean.UserRequestParam;
import com.fyp.islamic_digital_shelf.user.bean.UserView;

import java.util.List;

public interface UserService {
    UserView register(UserRequestParam request);
    LoginResponse login(String email, String password);
    String forgotPassword(String email, String newPassword);
    List<UserView> getAllUser();
    UserView getUserById(Long userId);
    UserView updateUser(Long id, UserRequestParam request);
    String deleteUser(Long id);


    User getRawUserById(Long adminId);
}
