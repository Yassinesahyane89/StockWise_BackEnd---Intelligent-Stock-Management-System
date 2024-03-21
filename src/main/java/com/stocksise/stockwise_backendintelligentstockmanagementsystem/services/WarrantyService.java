package com.stocksise.stockwise_backendintelligentstockmanagementsystem.services;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Warranty;

import java.util.List;

public interface WarrantyService {
    List<Warranty> getAllWarranties();
    Warranty getWarrantyById(Long id);
    Warranty createWarranty(Warranty warranty);
    Warranty updateWarranty(Long id,Warranty warranty);
    void deleteWarranty(Long id);
}
