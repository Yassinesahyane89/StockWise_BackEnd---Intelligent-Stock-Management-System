package com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.Impl;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler.OperationException;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler.ResourceNotFoundException;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Warranty;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.WarrantyRepository;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.WarrantyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class WarrantyServiceImpl implements WarrantyService {
    private final WarrantyRepository warrantyRepository;

    public WarrantyServiceImpl(WarrantyRepository warrantyRepository) {
        this.warrantyRepository = warrantyRepository;
    }
    @Override
    public List<Warranty> getAllWarranties() {
        return warrantyRepository.findAll();
    }

    @Override
    public Warranty getWarrantyById(Long id) {
        return warrantyRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Warranty not found with id: " + id)
        );
    }

    @Override
    public Warranty createWarranty(Warranty warranty) {
        // check if warranty name already exists
        if (warrantyRepository.findByName(warranty.getName()).isPresent()) {
            throw new OperationException("Warranty already exists");
        }

        return warrantyRepository.save(warranty);
    }

    @Override
    public Warranty updateWarranty(Long id,Warranty warranty) {
        // get the warranty by id
        Warranty warrantyToUpdate = this.getWarrantyById(id);

        // check if warranty name already exists
        if (warrantyRepository.findByName(warranty.getName()).isPresent() && !warrantyToUpdate.getName().equals(warranty.getName())) {
            throw new OperationException("Warranty already exists");
        }

        // set the warranty data
        warrantyToUpdate.setName(warranty.getName());
        warrantyToUpdate.setDescription(warranty.getDescription());
        warrantyToUpdate.setDuration(warranty.getDuration());
        warrantyToUpdate.setPeriod(warranty.getPeriod());
        warrantyToUpdate.setStatus(warranty.getStatus());

        return warrantyRepository.save(warrantyToUpdate);
    }

    @Override
    public void deleteWarranty(Long id) {
        // get the warranty by id
        this.getWarrantyById(id);

        // delete the warranty
        warrantyRepository.deleteById(id);
    }

    @Override
    public List<Warranty> filterWarrantyByStatus(String status) {
        return warrantyRepository.findByStatus(Objects.equals(status, "ACTIVE"));
    }
}
