package com.example.manufacturer_search_api;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/query")
    public Page<Supplier> querySuppliers(
            @RequestParam @NotBlank String location,
            @RequestParam @NotBlank String natureOfBusiness,
            @RequestParam @NotBlank String manufacturingProcesses,
            @RequestParam @Min(0) int page,
            @RequestParam @Min(1) int size) {
        return supplierService.findSuppliers(location, natureOfBusiness, manufacturingProcesses, page, size);
    }
}
