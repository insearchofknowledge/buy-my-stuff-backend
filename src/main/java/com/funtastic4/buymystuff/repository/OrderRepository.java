package com.funtastic4.buymystuff.repository;

import com.funtastic4.buymystuff.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    public List<Order> findOrdersByUserId(Long id);
}
