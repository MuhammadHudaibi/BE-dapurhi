package com.dapurhi.bedapurhi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemResponse {
    private String menuName;
    private Integer quantity;
    private Long priceAtTransaction;
    private Long subtotal;
}
