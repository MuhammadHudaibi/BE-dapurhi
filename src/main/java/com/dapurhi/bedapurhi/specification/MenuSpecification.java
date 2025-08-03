package com.dapurhi.bedapurhi.specification;

import com.dapurhi.bedapurhi.entity.Menu;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class MenuSpecification {
    public static Specification<Menu> getMenuSpecification(String name, Boolean isMainMenu, Boolean isActive) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null && !name.isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("name")),
                        "%" + name.toLowerCase() + "%")
                );
            }

            if (isActive != null) {
                predicates.add(criteriaBuilder.equal(root.get("isActive"), isActive));
            }

            if (isMainMenu != null) {
                predicates.add(criteriaBuilder.equal(root.get("isMainMenu"), isMainMenu));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}