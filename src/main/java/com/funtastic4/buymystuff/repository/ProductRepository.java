package com.funtastic4.buymystuff.repository;

import com.funtastic4.buymystuff.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findProductByCategoryId(long id);
}
