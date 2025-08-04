package com.dapurhi.bedapurhi.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
public class MenuRequest {

    @NotBlank(message = "Nama menu wajib diisi")
    private String name;

    private String description;

    @NotNull(message = "Harga wajib diisi")
    @Min(value = 0, message = "Harga tidak boleh kurang dari 0")
    private Long price;

    @NotNull(message = "Status menu utama wajib diisi")
    private Boolean isMainMenu;
}