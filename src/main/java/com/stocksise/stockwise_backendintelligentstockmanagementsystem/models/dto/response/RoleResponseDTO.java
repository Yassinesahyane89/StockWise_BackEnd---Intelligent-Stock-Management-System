package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Role;
import lombok.*;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RoleResponseDTO {
    private Long id;
    private String roleName;
    private String createdAt;

    // mapping from Role entity to RoleResponseDTO
    public static RoleResponseDTO fromRole(Role role){
        // date formatter example: 25 May 2023
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.US);
        return RoleResponseDTO.builder()
                .id(role.getId())
                .roleName(role.getName())
                .createdAt(role.getCreatedAt().format(dateFormatter))
                .build(
        );
    }
}
