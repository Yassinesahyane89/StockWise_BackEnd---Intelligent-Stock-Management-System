package com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.Impl;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler.OperationException;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler.ResourceNotFoundException;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request.ChangePasswordRequestDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request.UserRequestDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.User;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.UserRepository;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User getUserById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User with id " + id + " not found")
                );
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository
                .findByEmail(email)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User with email " + email + " not found")
                );
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(UserRequestDTO user) {
        // check if user with email already exists
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new OperationException("User with email " + user.getEmail() + " already exists");
        }

        // generate a random password
        String password = "password";

        // mapping userRequestDTO to user
        User newUser = user.toUser();

        // save password to user
        newUser.setPassword(password);

        // save user to database
        return userRepository.save(newUser);
    }

    @Override
    public User updateUser(UserRequestDTO user, Long id) {
        //get user by id
        User existingUser = getUserById(id);

        // check if user with email already exists
        if (userRepository.findByEmail(user.getEmail()).isPresent() && !user.getEmail().equals(existingUser.getEmail())) {
            throw new OperationException("email " + user.getEmail() + " already exists");
        }

        // mapping userRequestDTO to user
        User updatedUser = user.toUser();

        // set id to the user
        updatedUser.setId(id);

        // set password to the user
        updatedUser.setPassword(existingUser.getPassword());

        // save user to database
        return userRepository.save(updatedUser);
    }

    @Override
    public User updateUserPassword(ChangePasswordRequestDTO changePasswordRequestDTO, Long id) {
        //get user by id
        User existingUser = getUserById(id);

        // check if old password is correct
        if (!existingUser.getPassword().equals(changePasswordRequestDTO.getOldPassword())) {
            throw new OperationException("Old password is incorrect");
        }

        // check if new password is the same as old password
        if (existingUser.getPassword().equals(changePasswordRequestDTO.getNewPassword())) {
            throw new OperationException("New password cannot be the same as old password");
        }

        // check if new password is the same as confirm password
        if (!changePasswordRequestDTO.getNewPassword().equals(changePasswordRequestDTO.getConfirmPassword())) {
            throw new OperationException("New password and confirm password do not match");
        }

        // set new password
        existingUser.setPassword(changePasswordRequestDTO.getNewPassword());

        // save user to database
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        // check if user exists
        getUserById(id);

        // delete user
        userRepository.deleteById(id);
    }
}
