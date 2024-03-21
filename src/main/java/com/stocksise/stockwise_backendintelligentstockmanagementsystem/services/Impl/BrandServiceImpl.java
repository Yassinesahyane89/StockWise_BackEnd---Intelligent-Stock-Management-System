package com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.Impl;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler.OperationException;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.handlers.exceptionHandler.ResourceNotFoundException;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Brand;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.BrandRepository;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.services.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }
    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getBrandById(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found with id: " + id));
    }

    @Override
    public Brand saveBrand(Brand brand) {
        // check if the brand name already exists
        if (brandRepository.findByName(brand.getName()).isPresent()) {
            throw new OperationException("Brand already exists with name: " + brand.getName());
        }

        // check if the email already exists
        if (brandRepository.findByEmail(brand.getEmail()).isPresent()) {
            throw new OperationException("Brand already exists with email: " + brand.getEmail());
        }

        // save the brand
        return brandRepository.save(brand);
    }

    @Override
    public Brand updateBrand(Long id, Brand brand) {
        // get the brand by id
        Brand brandToUpdate = this.getBrandById(id);

        // check if the brand name already exists
        if (brandRepository.findByName(brand.getName()).isPresent() && !brandToUpdate.getName().equals(brand.getName())) {
            throw new OperationException("Brand already exists with name: " + brand.getName());
        }

        // check if the email already exists
        if (brandRepository.findByEmail(brand.getEmail()).isPresent() && !brandToUpdate.getEmail().equals(brand.getEmail())) {
            throw new OperationException("Brand already exists with email: " + brand.getEmail());
        }

        // update the brand
        brandToUpdate.setName(brand.getName());
        brandToUpdate.setEmail(brand.getEmail());
        brandToUpdate.setWebsite(brand.getWebsite());
        brandToUpdate.setStatus(brand.getStatus());

        // save the brand
        return brandRepository.save(brandToUpdate);
    }

    @Override
    public void deleteBrand(Long id) {
        // get the brand by id
        this.getBrandById(id);

        // delete the brand
        brandRepository.deleteById(id);
    }
}
