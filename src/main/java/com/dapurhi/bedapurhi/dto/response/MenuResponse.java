package com.dapurhi.bedapurhi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuResponse {
    private String menuId;
    private String menuName;
    private String menuDescription;
    private String imageUrl;
    private Long price;
    private Boolean isMainMenu;
    private Boolean isActive;
    private Boolean isDeleted;
}
