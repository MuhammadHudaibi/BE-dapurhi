package com.dapurhi.bedapurhi.controller;

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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping
    public ResponseEntity<CommonResponse<List<MenuResponse>>> getAllMenu(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "sortBy", defaultValue = "name") String sortBy,
            @RequestParam(name = "direction", defaultValue = "asc") String direction,
            @RequestParam(name = "isMainMenu", required = false) Boolean isMainMenu
    ){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));
        Page<MenuResponse> menuResponses = menuService.getAllMenu(pageable, isMainMenu);
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