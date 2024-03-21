package com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.Impl;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler.OperationException;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler.ResourceNotFoundException;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Unit;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.UnitRepository;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.UnitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {
    private final UnitRepository unitRepository;

    public UnitServiceImpl(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }
    @Override
    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }

    @Override
    public Unit getUnitById(Long id) {
        return unitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unit not found with id: " + id));
    }

    @Override
    public Unit saveUnit(Unit unit) {
        // check the unit name
        if (unitRepository.findByName(unit.getName()).isPresent()) {
            throw new OperationException("Unit with name: " + unit.getName() + " already exists");
        }

        // check short name
        if (unitRepository.findByShortName(unit.getShortName()).isPresent()) {
            throw new OperationException("Unit with short name: " + unit.getShortName() + " already exists");
        }

        // save the unit
        return unitRepository.save(unit);
    }

    @Override
    public Unit updateUnit(Long id, Unit unit) {
        // get the unit by id
        Unit unitToUpdate = this.getUnitById(id);

        // check the unit name
        if (unitRepository.findByName(unit.getName()).isPresent() && !unitToUpdate.getName().equals(unit.getName())) {
            throw new OperationException("Unit with name: " + unit.getName() + " already exists");
        }

        // check short name
        if (unitRepository.findByShortName(unit.getShortName()).isPresent() && !unitToUpdate.getShortName().equals(unit.getShortName())) {
            throw new OperationException("Unit with short name: " + unit.getShortName() + " already exists");
        }

        // update the unit
        unitToUpdate.setName(unit.getName());
        unitToUpdate.setShortName(unit.getShortName());
        unitToUpdate.setStatus(unit.getStatus());

        return unitRepository.save(unitToUpdate);
    }

    @Override
    public void deleteUnit(Long id) {
        // get the unit by id
        this.getUnitById(id);

        // delete the unit
        unitRepository.deleteById(id);
    }
}
