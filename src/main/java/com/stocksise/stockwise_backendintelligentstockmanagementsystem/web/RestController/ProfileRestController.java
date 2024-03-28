package com.stocksise.stockwise_backendintelligentstockmanagementsystem.web.RestController;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.response.ResponseMessage;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request.ChangePasswordRequestDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request.ProfileRequest;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response.ProfileResponseDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.User;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileRestController {
    private final UserService userService;

    public ProfileRestController(UserService userService) {
        this.userService = userService;
    }

    // update profile
    @PutMapping("/update-profile/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable Long id, @RequestBody ProfileRequest profileRequest) {
        // convert profile request dto to profile
        User user = ProfileRequest.toUser(profileRequest);

        // save the profile
        user = userService.updateUserProfile(id, user);

        // return response
        return ResponseMessage.ok(ProfileResponseDTO.fromProfile(user), "Profile updated successfully");
    }

    //update user password
    @PutMapping("/update-password/{id}")
    public ResponseEntity<?> updateUserPassword(@RequestBody ChangePasswordRequestDTO changePasswordRequestDTO, @PathVariable Long id){
        return ResponseMessage.ok(null, "Password updated successfully");
    }
}
