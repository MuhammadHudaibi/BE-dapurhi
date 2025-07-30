package com.dapurhi.bedapurhi.service.impl;

import com.dapurhi.bedapurhi.dto.response.MenuResponse;
import com.dapurhi.bedapurhi.entity.Menu;
import com.dapurhi.bedapurhi.mapper.MenuMapper;
import com.dapurhi.bedapurhi.repository.MenuRepository;
import com.dapurhi.bedapurhi.service.MenuService;
import com.dapurhi.bedapurhi.specification.MenuSpecification;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    @Override
    public Page<MenuResponse> getAllMenu(Pageable pageable, Boolean isMainMenu) {
        Specification<Menu> spec = MenuSpecification.getMenuSpecification(
                isMainMenu
        );

        Page<Menu> menuPage = menuRepository.findAll(spec, pageable);
        return menuPage.map(MenuMapper::toMenuResponse);
    }

    @Override
    public MenuResponse getMenuById(String id) {
        Menu menu = menuRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Menu with id " + id + " not found")
        );
        return MenuMapper.toMenuResponse(menu);
    }
}