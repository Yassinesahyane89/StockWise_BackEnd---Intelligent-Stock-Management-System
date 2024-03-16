package com.stocksise.stockwise_backendintelligentstockmanagementsystem.services;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request.ChangePasswordRequestDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request.UserRequestDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    User addUser(UserRequestDTO user);
    User updateUser(UserRequestDTO user, Long id);
    // change password
    User updateUserPassword(ChangePasswordRequestDTO changePasswordRequestDTO, Long id);
    void deleteUser(Long id);
}
