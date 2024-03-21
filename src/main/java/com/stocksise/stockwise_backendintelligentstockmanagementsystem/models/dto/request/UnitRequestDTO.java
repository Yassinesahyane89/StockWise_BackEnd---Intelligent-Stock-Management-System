package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Unit;
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
public class UnitRequestDTO {
    @NotNull(message = "Unit name is required")
    String unitName;

    @NotNull(message = "Short name is required")
    String shortName;

    @NotNull(message = "Status is required")
    String status;

    // mapping to unit
    public static Unit toUnit(UnitRequestDTO unitRequestDTO) {
        return Unit.builder()
                .name(unitRequestDTO.getUnitName())
                .shortName(unitRequestDTO.getShortName())
                .status(Objects.equals(unitRequestDTO.getStatus(), "Active"))
                .build();
    }
}
