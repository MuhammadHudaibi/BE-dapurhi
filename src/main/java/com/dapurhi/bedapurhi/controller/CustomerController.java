package com.dapurhi.bedapurhi.controller;

import com.dapurhi.bedapurhi.dto.request.CustomerRequest;
import com.dapurhi.bedapurhi.dto.response.CommonResponse;
import com.dapurhi.bedapurhi.dto.response.CustomerResponse;
import com.dapurhi.bedapurhi.service.CustomerService;
import com.dapurhi.bedapurhi.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<CommonResponse<CustomerResponse>> createCustomer(@RequestBody CustomerRequest customer){
        return ResponseUtil.createResponse(
                HttpStatus.CREATED,
                "Customer berhasil dibuat.",
                customerService.createCustomer(customer)
        );
    }

    @GetMapping
    public ResponseEntity<CommonResponse<List<CustomerResponse>>> getAllCustomers(){
        return ResponseUtil.createResponse(
                HttpStatus.OK,
                "Daftar customer didapatkan",
                customerService.getAllCustomers()
        );
    }
}
