package com.dapurhi.bedapurhi.service;

import com.dapurhi.bedapurhi.dto.request.CustomerRequest;
import com.dapurhi.bedapurhi.dto.response.CustomerResponse;
import com.dapurhi.bedapurhi.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    CustomerResponse createCustomer(CustomerRequest customerRequest);
    Page<CustomerResponse> getAllCustomers(Pageable pageable, String name);
    CustomerResponse getCustomerById(String id);
    CustomerResponse updateCustomer(String id, CustomerRequest customerRequest);
    void deleteCustomerById(String id);
    Customer getCustomerByIdForInternal(String id);
}
