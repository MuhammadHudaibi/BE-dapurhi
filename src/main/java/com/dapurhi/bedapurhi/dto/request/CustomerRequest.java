package com.dapurhi.bedapurhi.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
public class CustomerRequest {

    @Schema(description = "Nama lengkap pelanggan", example = "Budi Santoso")
    @NotBlank(message = "Nama pelanggan wajib diisi.")
    private String name;

    @Schema(description = "Nomor telepon aktif pelanggan", example = "081234567890")
    @NotBlank(message = "Nomor HP pelanggan wajib diisi.")
    private String phoneNumber;

    @Schema(description = "Alamat pengiriman pelanggan", example = "Jl. Merdeka No. 10, Bandung")
    @NotBlank(message = "Alamat pelanggan wajib diisi.")
    @Size(max = 240, message = "Alamat pelanggan tidak boleh lebih dari 240 karakter.")
    private String address;
}