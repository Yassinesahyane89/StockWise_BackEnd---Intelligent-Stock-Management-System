package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class JwtAuthenticationResponse {
    String accessToken;
}
