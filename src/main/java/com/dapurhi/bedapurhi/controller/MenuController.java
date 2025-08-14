package com.dapurhi.bedapurhi.controller;

import com.dapurhi.bedapurhi.dto.request.MenuRequest;
import com.dapurhi.bedapurhi.dto.response.CommonResponse;
import com.dapurhi.bedapurhi.dto.response.MenuResponse;
import com.dapurhi.bedapurhi.service.MenuService;
import com.dapurhi.bedapurhi.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
@RequiredArgsConstructor
@Tag(name = "Menu", description = "Operasi terkait menu makanan.")
public class MenuController {

    private final MenuService menuService;

    @Operation(summary = "Membuat menu baru", description = "Membuat menu baru dengan data yang diberikan dan gambar opsional. Gambar akan diunggah ke Cloudinary.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Menu berhasil dibuat"),
            @ApiResponse(responseCode = "400", description = "Input tidak valid", content = @Content),
            @ApiResponse(responseCode = "500", description = "Kesalahan server internal", content = @Content),
    })
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CommonResponse<MenuResponse>> createMenu(
            @Valid @ModelAttribute MenuRequest menuRequest,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) {
        return ResponseUtil.createResponse(
                HttpStatus.CREATED,
                "Menu berhasil dibuat",
                menuService.createMenu(menuRequest, image)
        );
    }

    @Operation(summary = "Mendapatkan semua menu", description = "Mengambil daftar menu dengan paginasi dan filter.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Daftar menu berhasil didapatkan")
    })
    @GetMapping
    public ResponseEntity<CommonResponse<List<MenuResponse>>> getAllMenu(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "sortBy", defaultValue = "name") String sortBy,
            @RequestParam(name = "direction", defaultValue = "asc") String direction,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "isMainMenu", required = false) Boolean isMainMenu,
            @RequestParam(name = "isActive", required = false) Boolean isActive
    ){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));
        Page<MenuResponse> menuResponses = menuService.getAllMenu(pageable, name, isMainMenu, isActive);
        return ResponseUtil.createResponse(
                HttpStatus.OK,
                "Daftar menu didapatkan",
                menuResponses
        );
    }

    @Operation(summary = "Mendapatkan menu berdasarkan ID", description = "Mengambil detail satu menu berdasarkan ID uniknya.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Menu ditemukan"),
            @ApiResponse(responseCode = "404", description = "Menu tidak ditemukan", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<MenuResponse>> getMenuById(@PathVariable String id){
        return ResponseUtil.createResponse(
                HttpStatus.OK,
                "Menu didapatkan",
                menuService.getMenuById(id)
        );
    }

    @Operation(summary = "Memperbaharui menu", description = "Memperbaharui data menu yang ada berdasarkan ID. Anda bisa memperbaharui data teks dan/atau mengunggah gambar baru.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Menu berhasil diperbaharui"),
            @ApiResponse(responseCode = "400", description = "Input tidak valid", content = @Content),
            @ApiResponse(responseCode = "404", description = "Menu tidak ditemukan", content = @Content)
    })
    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CommonResponse<MenuResponse>> updateMenu(
            @PathVariable String id,
            @RequestBody(
                    description = "Data menu dalam form-data",
                    content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE,
                            schema = @Schema(implementation = MenuRequest.class))
            )
            @ModelAttribute MenuRequest menuRequest,
            @RequestPart(required = false) MultipartFile image
    ){
        return ResponseUtil.createResponse(
                HttpStatus.OK,
                "Berhasil memperbaharui menu.",
                menuService.updateMenu(id, menuRequest, image)
        );
    }

    @Operation(summary = "Mengubah status aktif menu", description = "Mengubah status aktif/non-aktif sebuah menu (toggle). Jika aktif, akan menjadi non-aktif, begitu pula sebaliknya.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Status menu berhasil diubah"),
            @ApiResponse(responseCode = "404", description = "Menu tidak ditemukan", content = @Content)
    })
    @PatchMapping("/{id}")
    public ResponseEntity<CommonResponse<MenuResponse>> updateStatusMenu(@PathVariable String id){
        return ResponseUtil.createResponse(
                HttpStatus.OK,
                "Status menu berhasil diubah",
                menuService.updateStatus(id)
        );
    }

    @Operation(summary = "Menghapus menu (soft delete)", description = "Menghapus menu berdasarkan ID dengan metode soft delete (menandai 'isDeleted' menjadi true).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Menu berhasil dihapus"),
            @ApiResponse(responseCode = "404", description = "Menu tidak ditemukan", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse<String>> deleteMenuById(@PathVariable String id){
        menuService.deleteMenuById(id);
        return ResponseUtil.createResponse(
                HttpStatus.NO_CONTENT,
                "Berhasil menghapus menu",
                (String) null
        );
    }
}