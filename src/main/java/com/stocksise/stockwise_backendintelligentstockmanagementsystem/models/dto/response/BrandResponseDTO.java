package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Brand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandResponseDTO {
    private Long id;

    private String brand;

    private String email;

    private String website;

    private String createdOn;

    private String status;
    // mapping from brand
    public static BrandResponseDTO fromBrand(Brand brand) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.US);
        return BrandResponseDTO.builder()
                .id(brand.getId())
                .brand(brand.getName())
                .website(brand.getWebsite())
                .email(brand.getEmail())
                .status(brand.getStatus() ? "ACTIVE" : "INACTIVE")
                .createdOn(brand.getCreatedAt().format(dateFormatter))
                .build();
    }
}
