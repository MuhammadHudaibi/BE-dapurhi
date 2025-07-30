package com.dapurhi.bedapurhi.specification;

import com.dapurhi.bedapurhi.entity.Menu;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class MenuSpecification {
    public static Specification<Menu> getMenuSpecification(Boolean isMainMenu) {
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            predicates.add(criteriaBuilder.isTrue(root.get("isActive")));

            if (isMainMenu) {
                predicates.add(criteriaBuilder.equal(root.get("isMainMenu"), true));
            } else {
                predicates.add(criteriaBuilder.equal(root.get("isMainMenu"), false));
            }


            query.groupBy(root.get("id"));

            return query.where(predicates.toArray(new Predicate[0])).getRestriction();
        });
    }
}