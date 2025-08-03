package com.dapurhi.bedapurhi.service.impl;

import com.dapurhi.bedapurhi.dto.request.MenuRequest;
import com.dapurhi.bedapurhi.dto.response.MenuResponse;
import com.dapurhi.bedapurhi.entity.Menu;
import com.dapurhi.bedapurhi.mapper.MenuMapper;
import com.dapurhi.bedapurhi.repository.MenuRepository;
import com.dapurhi.bedapurhi.service.CloudinaryService;
import com.dapurhi.bedapurhi.service.MenuService;
import com.dapurhi.bedapurhi.specification.MenuSpecification;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final CloudinaryService cloudinaryService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MenuResponse createMenu(MenuRequest request, MultipartFile image) {
        String imageUrl = null;
        if (image != null && !image.isEmpty()) {
            imageUrl = cloudinaryService.uploadFile(image);
        }

        Menu menu = Menu.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .isMainMenu(request.getIsMainMenu())
                .imageUrl(imageUrl)
                .isActive(true)
                .isDeleted(false)
                .build();

        menuRepository.save(menu);
        return MenuMapper.toMenuResponse(menu);
    }

    @Override
    public Page<MenuResponse> getAllMenu(Pageable pageable, String name, Boolean isMainMenu, Boolean isActive) {
        Specification<Menu> spec = MenuSpecification.getMenuSpecification(
                name,
                isMainMenu,
                isActive
        );

        Page<Menu> menuPage = menuRepository.findAll(spec, pageable);
        return menuPage.map(MenuMapper::toMenuResponse);
    }

    @Override
    public MenuResponse getMenuById(String id) {
        Menu menu = getMenuByIdForInternal(id);
        return MenuMapper.toMenuResponse(menu);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MenuResponse updateMenu(String id, MenuRequest request, MultipartFile image) {
        Menu menu = getMenuByIdForInternal(id);

        String imageUrl;

        if (image != null && !image.isEmpty()) {
            imageUrl = cloudinaryService.uploadFile(image);
            menu.setImageUrl(imageUrl);
        }

        menu.setName(request.getName());
        menu.setDescription(request.getDescription());
        menu.setPrice(request.getPrice());
        menu.setIsMainMenu(request.getIsMainMenu());
        menuRepository.save(menu);

        return MenuMapper.toMenuResponse(menu);
    }

    @Override
    public MenuResponse updateStatus(String id) {
        Menu menu = getMenuByIdForInternal(id);

        menu.setIsActive(!menu.getIsActive());
        menuRepository.save(menu);

        return MenuMapper.toMenuResponse(menu);
    }

    @Override
    public void deleteMenuById(String id) {
        Menu menu = getMenuByIdForInternal(id);
        menu.setIsDeleted(true);
        menuRepository.save(menu);
    }

    @Override
    public Menu getMenuByIdForInternal(String id) {
        return menuRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Menu with id " + id + " not found")
        );
    }
}