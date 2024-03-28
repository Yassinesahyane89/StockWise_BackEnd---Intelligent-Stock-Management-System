package com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.Impl;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler.OperationException;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Brand;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.BrandRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BrandServiceImplTest {

    @Mock
    private BrandRepository brandRepository;

    @InjectMocks
    private BrandServiceImpl brandService;

    private Brand brand;

    @BeforeEach
    void setUp() {
        brand = Brand.builder()
                .name("Apple")
                .email("apple@gmail.com")
                .website("www.apple.com")
                .status(true)
                .build();
    }

    @DisplayName("Save Brand if the name already exists should throw exception")
    @Test
    void saveBrand_saveBrandInvalidName_shouldThrowException() {
        Brand invalidNameBrand = Brand.builder()
                .name(brand.getName())
                .build();

        when(brandRepository.findByName(invalidNameBrand.getName())).thenReturn(java.util.Optional.of(brand));

        OperationException exception = assertThrows(OperationException.class, () -> brandService.saveBrand(invalidNameBrand));
        assertEquals("Brand already exists with name: " + invalidNameBrand.getName(), exception.getMessage());
    }

    @DisplayName("Save Brand if the email already exists should throw exception")
    @Test
    void saveBrand_saveBrandInvalidEmail_shouldThrowException() {
        Brand invalidEmailBrand = Brand.builder()
                .email(brand.getEmail())
                .build();

        when(brandRepository.findByEmail(invalidEmailBrand.getEmail())).thenReturn(java.util.Optional.of(brand));

        OperationException exception = assertThrows(OperationException.class, () -> brandService.saveBrand(invalidEmailBrand));
        assertEquals("Brand already exists with email: " + invalidEmailBrand.getEmail(), exception.getMessage());
    }

    @DisplayName("Save Brand should pass with no exception")
    @Test
    void saveBrand_saveBrandValid_shouldPass() throws OperationException {
        Brand validBrand = Brand.builder()
                .name("hp")
                .email("hp@gmail.com")
                .website("www.hp.com")
                .status(true)
                .build();

        when(brandRepository.findByName(validBrand.getName())).thenReturn(java.util.Optional.empty());
        when(brandRepository.findByEmail(validBrand.getEmail())).thenReturn(java.util.Optional.empty());
        when(brandRepository.save(validBrand)).thenReturn(validBrand);
        Brand savedBrand = brandService.saveBrand(validBrand);
    }
}