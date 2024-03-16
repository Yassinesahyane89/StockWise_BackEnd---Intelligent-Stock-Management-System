package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.User;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.enums.userStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRegisterRequestDTO {
    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Pattern(regexp = "^(.+)@(.+)$", message = "Invalid email pattern")
    private String email;

    @NotBlank(message = "Password is required")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Password must contain at least 8 characters, including one letter and one number")
    private String password;

    @NotBlank(message = "Confirm password is required")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Password must contain at least 8 characters, including one letter and one number")
    // same as password
    private String confirmPassword;

    @NotBlank(message = "Status is required")
    private userStatus status;

    public User toUser() {
        return User.builder()
                .firstName(this.firstName)
                .lastName(this.lastName)
                .email(this.email)
                .password(this.password)
                .status(this.status)
                .build();
    }
}
