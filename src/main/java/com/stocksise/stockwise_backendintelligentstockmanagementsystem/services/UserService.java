package com.stocksise.stockwise_backendintelligentstockmanagementsystem.services;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request.ChangePasswordRequestDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request.UserRequestDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    User addUser(User user);
    User updateUser(User user, Long id);

    // update profile
    User updateUserProfile(Long id, User user);

    // change password
    User updateUserPassword(ChangePasswordRequestDTO changePasswordRequestDTO, Long id);
    void deleteUser(Long id);
}
