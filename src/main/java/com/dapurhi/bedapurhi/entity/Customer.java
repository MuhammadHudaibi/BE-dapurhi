package com.dapurhi.bedapurhi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(columnDefinition = "TEXT")
    private String address;

    @Builder.Default
    private Boolean isDeleted = false;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
