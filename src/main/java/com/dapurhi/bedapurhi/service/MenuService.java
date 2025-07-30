package com.dapurhi.bedapurhi.service;

import com.dapurhi.bedapurhi.dto.response.MenuResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MenuService {
    Page<MenuResponse> getAllMenu(Pageable pageable, Boolean isMainMenu);
    MenuResponse getMenuById(String id);
}
