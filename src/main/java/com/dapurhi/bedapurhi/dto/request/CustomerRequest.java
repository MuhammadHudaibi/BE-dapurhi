package com.dapurhi.bedapurhi.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
public class CustomerRequest {

    @NotBlank(message = "Nama pelanggan wajib diisi.")
    private String name;

    @NotBlank(message = "Nomor HP pelanggan wajib diisi.")
    private String phoneNumber;

    @NotBlank(message = "Alamat pelanggan wajib diisi.")
    @Size(max = 240, message = "Alamat pelanggan tidak boleh lebih dari 240 karakter.")
    private String address;
}