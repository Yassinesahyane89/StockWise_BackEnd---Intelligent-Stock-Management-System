package com.stocksise.stockwise_backendintelligentstockmanagementsystem.services;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Unit;

import java.util.List;

public interface UnitService {
    List<Unit> getAllUnits();
    Unit getUnitById(Long id);
    Unit saveUnit(Unit unit);
    Unit updateUnit(Long id, Unit unit);
    void deleteUnit(Long id);
}
