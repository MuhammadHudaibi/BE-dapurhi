package com.dapurhi.bedapurhi.service.impl;

import com.dapurhi.bedapurhi.dto.request.CustomerRequest;
import com.dapurhi.bedapurhi.dto.response.CustomerResponse;
import com.dapurhi.bedapurhi.entity.Customer;
import com.dapurhi.bedapurhi.entity.Menu;
import com.dapurhi.bedapurhi.mapper.CustomerMapper;
import com.dapurhi.bedapurhi.repository.CustomerRepository;
import com.dapurhi.bedapurhi.service.CustomerService;
import com.dapurhi.bedapurhi.specification.CustomerSpecification;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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
    public Page<CustomerResponse> getAllCustomers(Pageable page, String name) {
        Specification<Customer> spec =CustomerSpecification.getMenuSpecification(
                name
        );

        Page<Customer> customers = customerRepository.findAll(spec, page);
        return customers.map(CustomerMapper::toCustomerResponse);
    }

    @Override
    public Customer getCustomerByIdForInternal(String id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Customer dengan id " + id + " tidak ditemukan.")
        );
    }
}
