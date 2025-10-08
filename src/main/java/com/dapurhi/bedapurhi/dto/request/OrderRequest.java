package com.dapurhi.bedapurhi.dto.request;

import com.dapurhi.bedapurhi.constant.PaymentMethod;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {
    private String customerId;

    @NotNull(message = "Metode pembayaran wajib diisi")
    private PaymentMethod paymentMethod;

    @NotEmpty(message = "Pesanan harus memiliki setidaknya satu item")
    @Valid
    private List<OrderItemRequest> orderItems;
}
