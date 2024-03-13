package com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
