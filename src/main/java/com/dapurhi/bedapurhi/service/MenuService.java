package com.dapurhi.bedapurhi.service;

import com.dapurhi.bedapurhi.dto.request.MenuRequest;
import com.dapurhi.bedapurhi.dto.response.MenuResponse;
import com.dapurhi.bedapurhi.entity.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface MenuService {
    MenuResponse createMenu(MenuRequest request, MultipartFile image);
    Page<MenuResponse> getAllMenu(Pageable pageable, String menu, Boolean isMainMenu, Boolean isActive);
    MenuResponse getMenuById(String id);
    MenuResponse updateMenu(String id, MenuRequest request, MultipartFile image);
    MenuResponse updateStatus(String id);
    void deleteMenuById(String id);
    Menu getMenuByIdForInternal(String id);
}
