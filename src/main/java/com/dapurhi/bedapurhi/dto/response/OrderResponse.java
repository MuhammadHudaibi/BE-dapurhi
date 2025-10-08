package com.dapurhi.bedapurhi.dto.response;

import com.dapurhi.bedapurhi.constant.OrderStatus;
import com.dapurhi.bedapurhi.constant.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private String orderId;
    private String orderNumber;
    private String customerName;
    private LocalDateTime transactionDate;
    private Long totalAmount;
    private OrderStatus orderStatus;
    private PaymentMethod paymentMethod;
    private List<OrderItemResponse> orderItems;
}
