package com.dapurhi.bedapurhi.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    @NotBlank(message = "Nama tidak boleh kosong.")
    private String name;

    @NotBlank(message = "Nomor HP tidak boleh kosong.")
    private String phoneNumber;

    @Size(min = 1, max = 240, message = "Alamat harus diisi dan maksimal 240 karakter.")
    @NotBlank(message = "Alamat tidak boleh kosong.")
    private String address;
}
