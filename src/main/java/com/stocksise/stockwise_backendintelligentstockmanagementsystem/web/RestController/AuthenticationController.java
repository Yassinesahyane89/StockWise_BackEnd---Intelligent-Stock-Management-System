package com.stocksise.stockwise_backendintelligentstockmanagementsystem.web.RestController;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler.EmailAlreadyExistsException;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler.InvalidEmailOrPasswordException;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.response.ResponseMessage;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request.SignInRequestDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request.SignupRequestDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.User;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignupRequestDTO signupRequestDTO){
        try {
            return ResponseMessage.ok(authenticationService.signup(signupRequestDTO), "User created successfully");
        } catch (EmailAlreadyExistsException e) {
            return ResponseMessage.badRequest(e.getMessage());
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody SignInRequestDTO signupRequestDTO){
        try {
            return ResponseMessage.ok(authenticationService.login(signupRequestDTO), "Login successful");
        } catch (InvalidEmailOrPasswordException e) {
            return ResponseMessage.badRequest(e.getMessage());
        }
    }

    // return userDeatils.getAuthorities() from security context holder
    @GetMapping("/user")
    public ResponseEntity<?> getUser(){
        List<SimpleGrantedAuthority> user = (List<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        return ResponseEntity.ok(user);
    }
}
