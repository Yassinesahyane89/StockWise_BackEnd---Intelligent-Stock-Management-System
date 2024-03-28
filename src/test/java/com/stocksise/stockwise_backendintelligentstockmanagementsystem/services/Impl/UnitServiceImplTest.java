package com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.Impl;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler.OperationException;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Unit;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.UnitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UnitServiceImplTest {

    @Mock
    private UnitRepository unitRepository;

    @InjectMocks
    private UnitServiceImpl unitService;

    private Unit unit;
    @BeforeEach
    void setUp() {
        unit = Unit.builder()
                .name("Kilogram")
                .shortName("kg")
                .build();
    }

    @DisplayName("Save Unit if the name already exists should throw exception")
    @Test
    void saveUnit_saveUnitInvalidName_shouldThrowException() {
        Unit invalidNameUnit = Unit.builder()
                .name(unit.getName())
                .build();

        when(unitRepository.findByName(invalidNameUnit.getName())).thenReturn(java.util.Optional.of(unit));

        OperationException exception = assertThrows(OperationException.class, () -> unitService.saveUnit(invalidNameUnit));
        assertEquals("Unit with name: " + invalidNameUnit.getName() + " already exists", exception.getMessage());
    }

    @DisplayName("Save Unit if the short name already exists should throw exception")
    @Test
    void saveUnit_saveUnitInvalidShortName_shouldThrowException() {
        Unit invalidShortNameUnit = Unit.builder()
                .shortName(unit.getShortName())
                .build();

        when(unitRepository.findByShortName(invalidShortNameUnit.getShortName())).thenReturn(java.util.Optional.of(unit));

        OperationException exception = assertThrows(OperationException.class, () -> unitService.saveUnit(invalidShortNameUnit));
        assertEquals("Unit with short name: " + invalidShortNameUnit.getShortName() + " already exists", exception.getMessage());
    }

    @DisplayName("Save Unit should pass with no exception")
    @Test
    void saveUnit_saveUnitValid_shouldPass() {
        Unit validUnit = Unit.builder()
                .name("Gram")
                .shortName("g")
                .build();

        when(unitRepository.findByName(validUnit.getName())).thenReturn(java.util.Optional.empty());
        when(unitRepository.findByShortName(validUnit.getShortName())).thenReturn(java.util.Optional.empty());
        when(unitRepository.save(validUnit)).thenReturn(validUnit);

        Unit savedUnit = unitService.saveUnit(validUnit);
        assertEquals(validUnit.getName(), savedUnit.getName());
        assertEquals(validUnit.getShortName(), savedUnit.getShortName());
    }

    @DisplayName("Update Unit should pass with no exception")
    @Test
    void updateUnit_updateUnitValid_shouldPass() throws OperationException {
        Unit validUnit = Unit.builder()
                .name("Gram")
                .shortName("g")
                .build();

        when(unitRepository.findByName(validUnit.getName())).thenReturn(java.util.Optional.empty());
        when(unitRepository.findByShortName(validUnit.getShortName())).thenReturn(java.util.Optional.empty());
        when(unitRepository.findById(1L)).thenReturn(java.util.Optional.of(unit));
        when(unitRepository.save(unit)).thenReturn(unit);

        Unit updatedUnit = unitService.updateUnit(1L, validUnit);
        assertEquals(validUnit.getName(), updatedUnit.getName());
        assertEquals(validUnit.getShortName(), updatedUnit.getShortName());
    }
}