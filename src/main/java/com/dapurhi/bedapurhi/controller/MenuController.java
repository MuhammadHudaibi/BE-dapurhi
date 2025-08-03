package com.dapurhi.bedapurhi.controller;

import com.dapurhi.bedapurhi.dto.request.MenuRequest;
import com.dapurhi.bedapurhi.dto.response.CommonResponse;
import com.dapurhi.bedapurhi.dto.response.MenuResponse;
import com.dapurhi.bedapurhi.service.MenuService;
import com.dapurhi.bedapurhi.util.ResponseUtil;
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
public class MenuController {

    private final MenuService menuService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CommonResponse<MenuResponse>> createMenu(
            @RequestParam("name") String name,
            @RequestParam(name = "description", required = false) String description,
            @RequestParam("price") Long price,
            @RequestParam("isMainMenu") Boolean isMainMenu,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) {
        MenuRequest request = new MenuRequest(name, description, price, isMainMenu);
        return ResponseUtil.createResponse(
                HttpStatus.CREATED,
                "Menu berhasil dibuat",
                menuService.createMenu(request,image)
        );
    }

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

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<MenuResponse>> getMenuById(@PathVariable String id){
        return ResponseUtil.createResponse(
                HttpStatus.OK,
                "Menu didapatkan",
                menuService.getMenuById(id)
        );
    }
}