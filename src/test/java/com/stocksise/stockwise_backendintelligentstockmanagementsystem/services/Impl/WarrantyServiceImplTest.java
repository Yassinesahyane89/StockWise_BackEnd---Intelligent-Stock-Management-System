package com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.Impl;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler.OperationException;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Warranty;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.enums.PeriodsType;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.WarrantyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WarrantyServiceImplTest {

    @Mock
    private WarrantyRepository warrantyRepository;

    @InjectMocks
    private WarrantyServiceImpl warrantyService;

    private Warranty warranty;
    @BeforeEach
    void setUp() {
        warranty = Warranty.builder()
                .name("Apple")
                .description("Apple Warranty")
                .duration(1L)
                .period(PeriodsType.MONTH)
                .build();
    }

    @DisplayName("Save Warranty if the name already exists should throw exception")
    @Test
    void saveWarranty_saveWarrantyInvalidName_shouldThrowException() {
        Warranty invalidNameWarranty = Warranty.builder()
                .name(warranty.getName())
                .build();

        when(warrantyRepository.findByName(invalidNameWarranty.getName())).thenReturn(java.util.Optional.of(warranty));

        OperationException exception = assertThrows(OperationException.class, () -> warrantyService.createWarranty(invalidNameWarranty));
        assertEquals("Warranty already exists", exception.getMessage());
    }

    @DisplayName("Save Warranty should pass with no exception")
    @Test
    void saveWarranty_saveWarrantyValid_shouldPass() {
        Warranty validWarranty = Warranty.builder()
                .name("Samsung")
                .description("Samsung Warranty")
                .duration(1L)
                .period(PeriodsType.MONTH)
                .build();

        when(warrantyRepository.findByName(validWarranty.getName())).thenReturn(java.util.Optional.empty());

        Warranty savedWarranty = warrantyService.createWarranty(validWarranty);
        assertDoesNotThrow(() -> warrantyService.createWarranty(validWarranty));
    }
}