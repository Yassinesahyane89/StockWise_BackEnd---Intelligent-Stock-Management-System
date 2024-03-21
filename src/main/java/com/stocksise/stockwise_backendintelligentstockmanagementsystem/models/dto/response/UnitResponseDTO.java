package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Unit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnitResponseDTO {
    private Long id;
    private String unitName;
    private String shortName;
    private String status;

    public static UnitResponseDTO fromUnit(Unit unit) {
        return UnitResponseDTO.builder()
                .id(unit.getId())
                .unitName(unit.getName())
                .shortName(unit.getShortName())
                .status(unit.getStatus() ? "ACTIVE" : "INACTIVE")
                .build();
    }
}
