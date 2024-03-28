package com.stocksise.stockwise_backendintelligentstockmanagementsystem.web.RestController;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.response.ResponseMessage;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request.WarrantyRequestDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response.WarrantyResponseDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response.warrantyResponseByIdDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Warranty;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.WarrantyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/warranty")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WarrantyRestController {
    private final WarrantyService warrantyService;

    public WarrantyRestController(WarrantyService warrantyService) {
        this.warrantyService = warrantyService;
    }

    //get all warranties
    @GetMapping("/all")
    public ResponseEntity<?> getAllWarranties() {
        List<Warranty> warranties = warrantyService.getAllWarranties();
        if(warranties.isEmpty()) {
            return ResponseMessage.notFound("No warranty found");
        }else {
            List<WarrantyResponseDTO> warrantyResponseDTOS = new ArrayList<>();
            for(Warranty warranty : warranties) {
                warrantyResponseDTOS.add(WarrantyResponseDTO.fromWarranty(warranty));
            }
            return ResponseMessage.ok(warrantyResponseDTOS, "Success");
        }
    }

    //get warranty by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getWarrantyById(@PathVariable Long id) {
        // get the warranty by id
        Warranty warranty = warrantyService.getWarrantyById(id);

        // convert warranty to warranty response dto
        warrantyResponseByIdDTO warrantyResponseDTO = warrantyResponseByIdDTO.fromWarranty(warranty);

        // return response
        return ResponseMessage.ok(warrantyResponseDTO, "Success");
    }

    // add warranty
    @PostMapping("/new-warranty")
    public ResponseEntity<?> addWarranty(@RequestBody WarrantyRequestDTO warrantyRequestDTO){
        // convert warranty request dto to warranty
        Warranty warranty = WarrantyRequestDTO.toWarranty(warrantyRequestDTO);

        // save the warranty
        warranty = warrantyService.createWarranty(warranty);

        // convert warranty to warranty response dto
        WarrantyResponseDTO warrantyResponseDTO = WarrantyResponseDTO.fromWarranty(warranty);

        // return response
        return ResponseMessage.created(warrantyResponseDTO, "Warranty added successfully");
    }

    // update warranty
    @PutMapping("/update-warranty/{id}")
    public ResponseEntity<?> updateWarranty(@RequestBody WarrantyRequestDTO warrantyRequestDTO, @PathVariable Long id) {
        // convert warranty request dto to warranty
        Warranty warranty = WarrantyRequestDTO.toWarranty(warrantyRequestDTO);

        // update the warranty
        Warranty updatedWarranty = warrantyService.updateWarranty(id, warranty);

        // convert warranty to warranty response dto
        warrantyResponseByIdDTO warrantyResponseDTO = warrantyResponseByIdDTO.fromWarranty(updatedWarranty);

        // return response
        return ResponseMessage.ok(warrantyResponseDTO, "Warranty updated successfully");
    }

    // filter warranty by status
    @GetMapping("/filter-by-status/{status}")
    public ResponseEntity<?> filterWarrantyByStatus(@PathVariable String status) {
        // get the warranty by status
        List<Warranty> warranties = warrantyService.filterWarrantyByStatus(status);

        // convert warranty to warranty response dto
        List<WarrantyResponseDTO> warrantyResponseDTOS = new ArrayList<>();
        for(Warranty warranty : warranties) {
            warrantyResponseDTOS.add(WarrantyResponseDTO.fromWarranty(warranty));
        }

        // return response
        return ResponseMessage.ok(warrantyResponseDTOS, "Success");
    }

    // delete warranty
    @DeleteMapping("/delete-warranty/{id}")
    public ResponseEntity<?> deleteWarranty(@PathVariable Long id) {
        // delete the warranty
        warrantyService.deleteWarranty(id);

        // return response
        return ResponseMessage.ok(null,"Warranty deleted successfully");
    }
}
