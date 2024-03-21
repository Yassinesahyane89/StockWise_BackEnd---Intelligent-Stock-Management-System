package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Brand;
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
public class BrandRequest {
    @NotNull(message = "Brand name is required")
    private String brand;

    @NotNull(message = "Email is required")
    @Pattern(regexp = "^(.+)@(.+)$", message = "Invalid email format")
    private String email;

    @NotNull(message = "Website is required")
    @Pattern(regexp = "^(http|https)://(.+)$", message = "Invalid website format")
    private String website;

    @NotNull(message = "Status is required")
    private String status;

    // mapping to brand
    public static Brand toBrand(BrandRequest brandRequest) {
        return Brand.builder()
                .name(brandRequest.getBrand())
                .email(brandRequest.getEmail())
                .website(brandRequest.getWebsite())
                .status(brandRequest.getStatus().equals("Active"))
                .build();
    }
}
