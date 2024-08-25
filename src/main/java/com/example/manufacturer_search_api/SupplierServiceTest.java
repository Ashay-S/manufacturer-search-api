package com.example.manufacturer_search_api;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SupplierServiceTest {

    @Autowired
    private SupplierService supplierService;

    @MockBean
    private SupplierRepository supplierRepository;

    @Test
    void testFindSuppliers() {
        // Mock data
        Page<Supplier> mockPage = Mockito.mock(Page.class);
        Mockito.when(supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcesses(
                        Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.any(PageRequest.class)))
                .thenReturn(mockPage);

        // Test service method
        Page<Supplier> result = supplierService.findSuppliers("India", "small_scale", "3d_printing", 0, 10);

        // Verify results
        assertThat(result).isEqualTo(mockPage);
    }
}
