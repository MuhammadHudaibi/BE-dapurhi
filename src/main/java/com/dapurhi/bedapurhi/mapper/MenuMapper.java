package com.dapurhi.bedapurhi.mapper;

import com.dapurhi.bedapurhi.dto.response.MenuResponse;
import com.dapurhi.bedapurhi.entity.Menu;

public class MenuMapper {
    public static MenuResponse toMenuResponse(Menu menu) {
        return MenuResponse.builder()
                .menuId(menu.getId())
                .menuName(menu.getName())
                .menuDescription(menu.getDescription())
                .imageUrl(menu.getImageUrl())
                .price(menu.getPrice())
                .isMainMenu(menu.getIsMainMenu())
                .isActive(menu.getIsActive())
                .isDeleted(menu.getIsDeleted())
                .build();
    }
}
