package com.dapurhi.bedapurhi.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemRequest {
    @NotBlank(message = "ID menu wajib diisi")
    private String menuId;

    @Min(value = 1, message = "Jumlah minimal adalah 1")
    private Integer quantity;
}
