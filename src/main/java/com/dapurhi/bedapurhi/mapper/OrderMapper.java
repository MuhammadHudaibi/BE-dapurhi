package com.dapurhi.bedapurhi.mapper;

import com.dapurhi.bedapurhi.dto.response.OrderItemResponse;
import com.dapurhi.bedapurhi.dto.response.OrderResponse;
import com.dapurhi.bedapurhi.entity.Order;

import java.util.List;

public class OrderMapper {
    public static OrderResponse toOrderResponse(Order order) {
        List<OrderItemResponse> orderItems = order.getOrderItems().stream()
                .map(item -> OrderItemResponse.builder()
                        .menuName(item.getMenu().getName())
                        .quantity(item.getQuantity())
                        .priceAtTransaction(item.getPriceAtTransaction())
                        .subtotal(item.getSubtotal())
                        .build())
                .toList();


        return OrderResponse.builder()
                .orderId(order.getId())
                .orderNumber(order.getOrderNumber())
                .customerName(order.getCustomer() != null ? order.getCustomer().getName() : "Walk-in")
                .transactionDate(order.getTransactionDate())
                .totalAmount(order.getTotalAmount())
                .orderStatus(order.getOrderStatus())
                .paymentMethod(order.getPaymentMethod())
                .orderItems(orderItems)
                .build();
    }
}
