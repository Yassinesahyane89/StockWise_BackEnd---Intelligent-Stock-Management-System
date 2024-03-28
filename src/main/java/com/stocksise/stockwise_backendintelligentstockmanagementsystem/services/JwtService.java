package com.stocksise.stockwise_backendintelligentstockmanagementsystem.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;

public interface JwtService {
    String generateToken(UserDetails userDetails);
    String extractUsername(String token);
    Jwt extractClaims(String token);
    boolean isTokenExpired(String token);
    boolean isValidateToken(String token, UserDetails userDetails);
}
