package com.funtastic4.buymystuff.repository;

import com.funtastic4.buymystuff.model.AppUser;
import com.funtastic4.buymystuff.model.Order;
import com.funtastic4.buymystuff.model.OrderLine;
import com.funtastic4.buymystuff.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

    Optional<OrderLine> getOrderLineByAppUserIdAndProductAndOrderIsNull(Long appUser_id, Product product);

    List<OrderLine> getOrderLinesByAppUserIdAndOrderIsNull(Long appUser_id);

    @Modifying
    @Query("update OrderLine a set a.order = ?1 where a.appUser = ?2 and a.order is null")
    void updateOrderLines(@Param("order_obj")Order order, @Param ("user_obj") AppUser appUser);

    @Modifying
    @Query("update Order a set a.totalCost =(select sum(ord.quantity * ord.productPrice ) from OrderLine ord where ord.order = ?1) where a.id = ?2")
    void getTotalCost(Order order, Long orderId);

}
