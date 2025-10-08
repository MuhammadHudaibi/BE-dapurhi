package com.dapurhi.bedapurhi.service;

import com.dapurhi.bedapurhi.dto.request.OrderRequest;
import com.dapurhi.bedapurhi.dto.response.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse createOrder(OrderRequest orderRequest);
    List<OrderResponse> getOrders();
}
