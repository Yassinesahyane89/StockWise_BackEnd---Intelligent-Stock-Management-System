package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Warranty;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.enums.PeriodsType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarrantyRequestDTO {
    @NotNull(message = "Warranty name is required")
    String name;
    
    @NotNull(message = "Duration is required")
    Long duration;
    
    @NotNull(message = "Period type is required")
    String periodType;
    
    @NotNull(message = "Description is required")
    String description;
    
    @NotNull(message = "Status is required")
    String status;

    // mapping to warranty
    public static Warranty toWarranty(WarrantyRequestDTO warrantyRequestDTO) {
        return Warranty.builder()
                .name(warrantyRequestDTO.getName())
                .duration(warrantyRequestDTO.getDuration())
                .period(PeriodsType.valueOf(warrantyRequestDTO.getPeriodType()))
                .description(warrantyRequestDTO.getDescription())
                .status(Objects.equals(warrantyRequestDTO.getStatus(), "Active"))
                .build();
    }
}
