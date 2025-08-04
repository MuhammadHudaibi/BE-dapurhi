package com.dapurhi.bedapurhi.service;

import com.dapurhi.bedapurhi.dto.request.CustomerRequest;
import com.dapurhi.bedapurhi.dto.response.CustomerResponse;
import com.dapurhi.bedapurhi.entity.Customer;

import java.util.List;

public interface CustomerService {
    CustomerResponse createCustomer(CustomerRequest customerRequest);
    List<CustomerResponse> getAllCustomers();
    Customer getCustomerByIdForInternal(String id);
}
