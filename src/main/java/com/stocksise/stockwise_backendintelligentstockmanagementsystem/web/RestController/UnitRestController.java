package com.stocksise.stockwise_backendintelligentstockmanagementsystem.web.RestController;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.response.ResponseMessage;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.request.UnitRequestDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.dto.response.UnitResponseDTO;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Unit;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.UnitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/unit")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UnitRestController {
    private final UnitService unitService;

    public UnitRestController(UnitService unitService) {
        this.unitService = unitService;
    }

    // get all units
    @GetMapping("/all")
    public ResponseEntity<?> getAllUnits() {
        List<Unit> units = unitService.getAllUnits();
        if(units.isEmpty()) {
            return ResponseMessage.notFound("No unit found");
        }else {
            List<UnitResponseDTO> unitResponseDTOS = new ArrayList<>();
            for(Unit unit : units) {
                unitResponseDTOS.add(UnitResponseDTO.fromUnit(unit));
            }
            return ResponseMessage.ok(unitResponseDTOS, "Success");
        }
    }

    // get unit by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getUnitById(@PathVariable Long id) {
        // get the unit by id
        Unit unit = unitService.getUnitById(id);

        // convert unit to unit response dto
        UnitResponseDTO unitResponseDTO = UnitResponseDTO.fromUnit(unit);

        // return response
        return ResponseMessage.ok(unitResponseDTO, "Success");
    }

    // add unit
    @PostMapping("/new-unit")
    public ResponseEntity<?> addUnit(@RequestBody UnitRequestDTO unitRequestDTO) {
        // convert unit request dto to unit
        Unit unit = UnitRequestDTO.toUnit(unitRequestDTO);

        // save the unit
        unit=unitService.saveUnit(unit);

        // convert unit to unit response dto
        UnitResponseDTO unitResponseDTO = UnitResponseDTO.fromUnit(unit);

        // return response
        return ResponseMessage.ok(unitResponseDTO, "Unit added successfully");
    }

    // update unit
    @PutMapping("/update-unit/{id}")
    public ResponseEntity<?> updateUnit(@PathVariable Long id, @RequestBody UnitRequestDTO unitRequestDTO) {
        // convert unit request dto to unit
        Unit unit = UnitRequestDTO.toUnit(unitRequestDTO);

        // update the unit
        unit=unitService.updateUnit(id, unit);

        // convert unit to unit response dto
        UnitResponseDTO unitResponseDTO = UnitResponseDTO.fromUnit(unit);

        // return response
        return ResponseMessage.ok(unitResponseDTO, "Unit updated successfully");
    }

    // delete unit
    @DeleteMapping("/delete-unit/{id}")
    public ResponseEntity<?> deleteUnit(@PathVariable Long id) {
        // delete the unit
        unitService.deleteUnit(id);

        // return response
        return ResponseMessage.ok(null,"Unit deleted successfully");
    }
}
