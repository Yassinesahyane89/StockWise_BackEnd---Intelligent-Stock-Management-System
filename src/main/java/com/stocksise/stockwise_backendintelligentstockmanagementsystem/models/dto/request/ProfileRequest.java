package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileRequest {
    @NotNull(message = "First name is required")
    private String firstName;

    @NotNull(message = "Last name is required")
    private String lastName;

    @NotNull(message = "Email is required")
    @Pattern(regexp = "^(.+)@(.+)$", message = "Invalid email pattern")
    private String email;

    public static User toUser(ProfileRequest profileRequest) {
        return User.builder()
                .firstName(profileRequest.getFirstName())
                .lastName(profileRequest.getLastName())
                .email(profileRequest.getEmail())
                .build();
    }
}
