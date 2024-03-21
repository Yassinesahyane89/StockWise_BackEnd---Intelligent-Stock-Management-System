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
public class warrantyResponseByIdDTO {
    Long id;
    String name;
    Long duration;
    String periodType;
    String description;
    String status;

    public static warrantyResponseByIdDTO fromWarranty(Warranty warranty){
        return warrantyResponseByIdDTO.builder()
                .id(warranty.getId())
                .name(warranty.getName())
                .description(warranty.getDescription())
                .duration(warranty.getDuration())
                .periodType(warranty.getPeriod().toString())
                .status(warranty.getStatus() ? "ACTIVE" : "INACTIVE")
                .build();
    }
}
