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
public class CommonResponse <T>{
    @Schema(example = "Kode status HTTP")
    private int code;
    @Schema(example = "Pesan yang menjelaskan hasil dari request")
    private String message;
    @Schema(description = "Data payload dari respons")
    private T data;
    @Schema(description = "Informasi paginasi, hanya ada jika respons berupa daftar (list)")
    private PagingResponse paging;
}