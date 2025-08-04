package com.dapurhi.bedapurhi.service.impl;

import com.dapurhi.bedapurhi.dto.request.CustomerRequest;
import com.dapurhi.bedapurhi.dto.response.CustomerResponse;
import com.dapurhi.bedapurhi.entity.Customer;
import com.dapurhi.bedapurhi.mapper.CustomerMapper;
import com.dapurhi.bedapurhi.repository.CustomerRepository;
import com.dapurhi.bedapurhi.service.CustomerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .name(customerRequest.getName())
                .phoneNumber(customerRequest.getPhoneNumber())
                .address(customerRequest.getAddress())
                .build();

        customerRepository.save(customer);

        return CustomerMapper.toCustomerResponse(customer);
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(CustomerMapper::toCustomerResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Customer getCustomerByIdForInternal(String id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Customer dengan id " + id + " tidak ditemukan.")
        );
    }
}
