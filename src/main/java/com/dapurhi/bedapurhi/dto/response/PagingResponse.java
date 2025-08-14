package com.dapurhi.bedapurhi.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PagingResponse {
    @Schema(description = "Halaman saat ini", example = "1")
    private int currentPage;
    @Schema(description = "Total semua halaman yang tersedia", example = "5")
    private int totalPage;
    @Schema(description = "Jumlah data per halaman", example = "10")
    private int size;
    @Schema(description = "Total semua elemen data yang tersedia", example = "45")
    private long totalElements;
    @Schema(description = "Apakah ada halaman berikutnya", example = "true")
    private boolean hasNext;
    @Schema(description = "Apakah ada halaman sebelumnya", example = "false")
    private boolean hasPrevious;
}