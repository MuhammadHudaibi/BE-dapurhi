package com.dapurhi.bedapurhi.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
public class MenuRequest {

    @Schema(description = "Nama menu", example = "Nasi Goreng Spesial")
    @NotBlank(message = "Nama menu wajib diisi")
    private String name;

    @Schema(description = "Deskripsi singkat mengenai menu", example = "Nasi goreng dengan telur, ayam, dan bakso")
    private String description;

    @Schema(description = "Harga menu dalam Rupiah", example = "25000")
    @NotNull(message = "Harga wajib diisi")
    @Min(value = 0, message = "Harga tidak boleh kurang dari 0")
    private Long price;

    @Schema(description = "Menandakan apakah ini menu utama atau bukan", example = "true")
    @NotNull(message = "Status menu utama wajib diisi")
    private Boolean isMainMenu;
}