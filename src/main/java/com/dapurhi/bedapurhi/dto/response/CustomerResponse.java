package com.dapurhi.bedapurhi.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    @Schema(description = "ID unik dari customer", example = "a1b2c3d4-e5f6-g7h8-i9j0-k1l2m3n4o5p6")
    private String id;
    @Schema(description = "Nama customer", example = "Budi Santoso")
    private String name;
    @Schema(description = "Nomor telepon customer", example = "081234567890")
    private String phoneNumber;
    @Schema(description = "Alamat customer", example = "Jl. Merdeka No. 10, Bandung")
    private String address;
    @Schema(description = "Waktu customer dibuat", example = "2024-07-28T10:30:00")
    private LocalDateTime createdAt;
}