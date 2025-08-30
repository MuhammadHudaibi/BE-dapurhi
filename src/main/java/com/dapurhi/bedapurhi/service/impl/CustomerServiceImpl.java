package com.dapurhi.bedapurhi.service.impl;

import com.dapurhi.bedapurhi.dto.request.CustomerRequest;
import com.dapurhi.bedapurhi.dto.response.CustomerResponse;
import com.dapurhi.bedapurhi.entity.Customer;
import com.dapurhi.bedapurhi.exception.ResourceNotFoundException;
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
    public CustomerResponse getCustomerById(String id) {
        return CustomerMapper.toCustomerResponse(getCustomerByIdForInternal(id));
    }

    @Override
    public CustomerResponse updateCustomer(String id, CustomerRequest customerRequest) {
        Customer customer = getCustomerByIdForInternal(id);

        if (customerRequest.getName() != null) {
            customer.setName(customerRequest.getName());
        }

        if (customerRequest.getPhoneNumber() != null) {
            customer.setPhoneNumber(customer.getPhoneNumber());
        }

        if (customerRequest.getAddress() != null) {
            customer.setAddress(customer.getAddress());
        }

        customerRepository.save(customer);
        return CustomerMapper.toCustomerResponse(customer);
    }

    @Override
    public void deleteCustomerById(String id) {
        Customer customer = getCustomerByIdForInternal(id);
        customer.setIsDeleted(true);
        customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerByIdForInternal(String id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Customer dengan id " + id + " tidak ditemukan.")
        );
    }
}
