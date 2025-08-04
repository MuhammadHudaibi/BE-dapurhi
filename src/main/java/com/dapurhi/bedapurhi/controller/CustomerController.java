package com.dapurhi.bedapurhi.controller;

import com.dapurhi.bedapurhi.dto.request.CustomerRequest;
import com.dapurhi.bedapurhi.dto.response.CommonResponse;
import com.dapurhi.bedapurhi.dto.response.CustomerResponse;
import com.dapurhi.bedapurhi.service.CustomerService;
import com.dapurhi.bedapurhi.util.ResponseUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CommonResponse<CustomerResponse>> createCustomer(@Valid @RequestBody CustomerRequest customer){
        return ResponseUtil.createResponse(
                HttpStatus.CREATED,
                "Customer berhasil dibuat.",
                customerService.createCustomer(customer)
        );
    }

    @GetMapping
    public ResponseEntity<CommonResponse<List<CustomerResponse>>> getAllCustomers(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "sortBy", defaultValue = "name") String sortBy,
            @RequestParam(name = "direction", defaultValue = "asc") String direction,
            @RequestParam(name = "name", required = false) String name
    ){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        Pageable pageable = PageRequest.of(page, size, sortDirection, sortBy);
        Page<CustomerResponse> customerResponses = customerService.getAllCustomers(pageable, name);
        return ResponseUtil.createResponse(
                HttpStatus.OK,
                "Daftar customer didapatkan",
                customerResponses
        );
    }
}
