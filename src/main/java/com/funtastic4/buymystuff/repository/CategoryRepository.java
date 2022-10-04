package com.funtastic4.buymystuff.repository;

import com.funtastic4.buymystuff.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository <Category, Long> {

    Optional<Category> findCategoryByName(String name);
}
