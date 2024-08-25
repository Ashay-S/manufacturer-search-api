package com.example.manufacturer_search_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Page<Supplier> findSuppliers(String location, String natureOfBusiness, String manufacturingProcesses, int page, int size) {
        return supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcesses(
                location,
                natureOfBusiness,
                manufacturingProcesses,
                PageRequest.of(page, size)
        );
    }
}
