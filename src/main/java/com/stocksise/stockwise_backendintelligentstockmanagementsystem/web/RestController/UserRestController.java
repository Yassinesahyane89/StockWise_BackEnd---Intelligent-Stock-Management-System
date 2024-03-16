package com.stocksise.stockwise_backendintelligentstockmanagementsystem.web.RestController;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.response.ResponseMessage;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request.ChangePasswordRequestDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request.UserRequestDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response.UserResponseDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response.UserResponseV2DTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.User;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    // get all users
    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers(){
        List<User> users = userService.getAllUsers();
        if(users.isEmpty()){
            return ResponseMessage.notFound("No user found");
        }else {
            List<UserResponseDTO> userResponseDTOS = new ArrayList<>();
            for(User user : users){
                userResponseDTOS.add(UserResponseDTO.fromUser(user));
            }
            return ResponseMessage.ok(userResponseDTOS, "Success");
        }
    }

    // get user by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        return ResponseMessage.ok(UserResponseV2DTO.fromUser(userService.getUserById(id)), "Success");
    }

    // get user by email
    @GetMapping("/email/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    //add user
    @PostMapping("/new-user")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserRequestDTO user){
        User newUser = userService.addUser(user);
        return ResponseMessage
                .created(UserResponseDTO.fromUser(newUser), "User added successfully");

    }

    //update user
    @PutMapping("/update-user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id,@Valid @RequestBody UserRequestDTO user){
        User updatedUser = userService.updateUser(user, id);
        if(updatedUser == null){
            return ResponseMessage.badRequest("User not updated");
        }else {
            return ResponseMessage.created(UserResponseDTO.fromUser(updatedUser), "User updated successfully");
        }
    }

    //update user password
    @PutMapping("/update-password/{id}")
    public ResponseEntity<?> updateUserPassword(@RequestBody ChangePasswordRequestDTO changePasswordRequestDTO, @PathVariable Long id){
        return ResponseEntity.ok(userService.updateUserPassword(changePasswordRequestDTO, id));
    }

    //delete user
    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseMessage.ok(null, "User deleted successfully");
    }
}
