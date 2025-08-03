package com.dapurhi.bedapurhi.service;

import com.dapurhi.bedapurhi.dto.request.MenuRequest;
import com.dapurhi.bedapurhi.dto.response.MenuResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface MenuService {
    MenuResponse createMenu(MenuRequest request, MultipartFile image);
    Page<MenuResponse> getAllMenu(Pageable pageable, String menu, Boolean isMainMenu, Boolean isActive);
    MenuResponse getMenuById(String id);
}
