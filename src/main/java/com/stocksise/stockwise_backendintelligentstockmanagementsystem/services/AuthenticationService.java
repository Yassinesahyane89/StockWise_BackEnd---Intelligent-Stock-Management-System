package com.stocksise.stockwise_backendintelligentstockmanagementsystem.services;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler.EmailAlreadyExistsException;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler.InvalidEmailOrPasswordException;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request.SignInRequestDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request.SignupRequestDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response.AuthResponseDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    AuthResponseDTO signup(SignupRequestDTO signupRequestDTO) throws EmailAlreadyExistsException;
    AuthResponseDTO login(SignInRequestDTO signInRequestDTO) throws InvalidEmailOrPasswordException;
}
