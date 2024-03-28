package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Role;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.User;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.enums.userStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRequestDTO {
    @NotNull(message = "First name is required")
    private String firstName;

    @NotNull(message = "Last name is required")
    private String lastName;

    @NotNull(message = "Email is required")
    @Pattern(regexp = "^(.+)@(.+)$", message = "Invalid email pattern")
    private String email;

    @NotNull(message = "Status is required")
    //@Pattern(regexp = "^(ACTIVE|INACTIVE)$", message = "Invalid status")
    private String status;

    @NotNull(message = "Status is required")
    private Long roleId;

    public User toUser() {
        return User.builder()
                .firstName(this.firstName)
                .lastName(this.lastName)
                .email(this.email)
                .status(userStatus.valueOf(status))
                .role(
                        Role.builder()
                                .id(this.roleId)
                                .build()
                )
                .build();
    }
}
