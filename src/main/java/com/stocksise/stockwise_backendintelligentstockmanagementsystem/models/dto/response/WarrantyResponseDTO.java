package com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Warranty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarrantyResponseDTO {
    Long id;
    String name;
    String duration;
    String description;
    String status;

    public static WarrantyResponseDTO fromWarranty(Warranty warranty){
        return WarrantyResponseDTO.builder()
                .id(warranty.getId())
                .name(warranty.getName())
                .description(warranty.getDescription())
                .duration(warranty.getDuration() + " " + warranty.getPeriod())
                .status(warranty.getStatus() ? "ACTIVE" : "INACTIVE")
                .build();
    }
}
