package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChangePasswordRequestDTO {
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;

    // data to insert in postman
//     {
//         "oldPassword": "password",
//         "newPassword": "newpassword",
//         "confirmPassword": "newpassword"
//     }
}
