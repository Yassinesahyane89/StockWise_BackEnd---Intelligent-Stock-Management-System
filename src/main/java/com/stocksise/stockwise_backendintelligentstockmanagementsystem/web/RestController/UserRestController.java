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
import org.springframework.security.access.prepost.PreAuthorize;
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
        // get user by id
        User user = userService.getUserById(id);

        //convert user to UserResponseV2DTO
        UserResponseV2DTO userResponseV2DTO = UserResponseV2DTO.fromUser(user);

        //return response
        return ResponseMessage.ok(userResponseV2DTO, "Success");
    }

    // get user by email
    @GetMapping("/email/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email){
        // get user by email
        User user = userService.getUserByEmail(email);

        //return response
        return ResponseEntity.ok(user);
    }

    //add user
    @PostMapping("/new-user")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
        // convert UserRequestDTO to User
        User user = userRequestDTO.toUser();

        // save user
        user = userService.addUser(user);

        // convert User to UserResponseDTO
        UserResponseDTO userResponseDTO = UserResponseDTO.fromUser(user);

        // return response
        return ResponseMessage.created(userResponseDTO, "User added successfully");

    }

    //update user
    @PutMapping("/update-user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id,@Valid @RequestBody UserRequestDTO userRequestDTO){
        // convert UserRequestDTO to User
        User user = userRequestDTO.toUser();

        // update user
        User updatedUser = userService.updateUser(user, id);
        if(updatedUser == null){
            return ResponseMessage.badRequest("User not updated");
        }else {
            // convert User to UserResponseDTO
            UserResponseDTO userResponseDTO = UserResponseDTO.fromUser(updatedUser);
            return ResponseMessage.created(userResponseDTO, "User updated successfully");
        }
    }

    //delete user
    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        // delete user
        userService.deleteUser(id);

        // return response
        return ResponseMessage.ok(null, "User deleted successfully");
    }
}
