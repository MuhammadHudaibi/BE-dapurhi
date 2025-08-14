package com.dapurhi.bedapurhi.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuResponse {
    @Schema(description = "ID unik dari menu", example = "c2a8f8e1-5b7f-4b0e-8d2a-0e6f8b9b3c1d")
    private String menuId;
    @Schema(description = "Nama menu", example = "Sate Ayam Madura")
    private String menuName;
    @Schema(description = "Deskripsi menu", example = "Sate ayam dengan bumbu kacang khas Madura")
    private String menuDescription;
    @Schema(description = "URL gambar menu dari Cloudinary", example = "https://res.cloudinary.com/demo/image/upload/sample.jpg")
    private String imageUrl;
    @Schema(description = "Harga menu", example = "30000")
    private Long price;
    @Schema(description = "Status apakah menu ini adalah menu utama", example = "true")
    private Boolean isMainMenu;
    @Schema(description = "Status apakah menu ini aktif dan dapat dipesan", example = "true")
    private Boolean isActive;
    @Schema(description = "Status apakah menu ini telah dihapus (soft delete)", example = "false")
    private Boolean isDeleted;
}