package com.dapurhi.bedapurhi.mapper;

import com.dapurhi.bedapurhi.dto.response.CustomerResponse;
import com.dapurhi.bedapurhi.entity.Customer;

public class CustomerMapper {
    public static CustomerResponse toCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .phoneNumber(customer.getPhoneNumber())
                .address(customer.getAddress())
                .createdAt(customer.getCreatedAt())
                .build();
    }
}
