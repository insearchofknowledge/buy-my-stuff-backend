package com.funtastic4.buymystuff.repository;

import com.funtastic4.buymystuff.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category, Long> {
}
