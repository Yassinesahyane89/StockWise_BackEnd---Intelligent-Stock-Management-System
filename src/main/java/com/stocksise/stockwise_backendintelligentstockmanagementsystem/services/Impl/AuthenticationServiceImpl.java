package com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.Impl;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler.EmailAlreadyExistsException;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler.InvalidEmailOrPasswordException;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler.PasswordsDoNotMatchException;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request.SignInRequestDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request.SignupRequestDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response.AuthResponseDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response.JwtAuthenticationResponse;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.User;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.enums.userStatus;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.AuthenticationService;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.JwtService;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationServiceImpl(UserService userService, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }
    @Override
    public AuthResponseDTO signup(SignupRequestDTO signupRequestDTO) throws EmailAlreadyExistsException {
        // check if user exists by email
        User user = userService.getUserByEmail(signupRequestDTO.getEmail());
        if (user != null) {
            // throw exception
            throw new EmailAlreadyExistsException("Email already exists");
        }

        // check the password and confirm password
//        if (!signupRequestDTO.getPassword().equals(signupRequestDTO.getConfirmPassword())) {
//            throw new PasswordsDoNotMatchException("Password and confirm password do not match");
//        }
        // encrypt password
        String encodedPassword = passwordEncoder.encode(signupRequestDTO.getPassword());

        // set the encoded password
        signupRequestDTO.setPassword(encodedPassword);

        // convert the signup request to user
        User userSave = signupRequestDTO.toUser();

        // set user status INACTIVE
        userSave.setStatus(userStatus.INACTIVE);

        // create user
        userSave = userService.addUser(userSave);

        //generate token
        String token = jwtService.generateToken(userSave);

        // return response
        return AuthResponseDTO.fromAuthResponseDTO(userSave, token);
    }

    @Override
    public AuthResponseDTO login(SignInRequestDTO signInRequestDTO) throws InvalidEmailOrPasswordException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequestDTO.getEmail(), signInRequestDTO.getPassword()));
        //check if user exists by email
        User user = userService.getUserByEmail(signInRequestDTO.getEmail());
        if (user != null) {
            // check if password matches
            if (passwordEncoder.matches(signInRequestDTO.getPassword(), user.getPassword())) {

                if(!user.getStatus().equals(userStatus.ACTIVE)){
                    throw new InvalidEmailOrPasswordException("User is inactive");
                }else {
                    // generate token
                    String token = jwtService.generateToken(user);
                    // return response
                    return AuthResponseDTO.fromAuthResponseDTO(user, token);
                }
            }
        }
        throw new InvalidEmailOrPasswordException("Invalid email or password");
    }
}
