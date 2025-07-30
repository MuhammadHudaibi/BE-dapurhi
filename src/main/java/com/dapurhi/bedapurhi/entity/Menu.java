package com.dapurhi.bedapurhi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "menus")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;
    private String description;
    private String imageUrl;

    @Column(nullable = false)
    private Long price;
    private Boolean isMainMenu = false;
    private Boolean isActive = true;
}
