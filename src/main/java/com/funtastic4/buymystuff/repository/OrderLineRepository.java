package com.funtastic4.buymystuff.repository;

import com.funtastic4.buymystuff.model.OrderLine;
import com.funtastic4.buymystuff.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

    Optional<OrderLine> getOrderLineByAppUserIdAndProductAndOrderIsNull(Long appUser_id, Product product);

    //List<OrderLine> getOrderLinesByAppUserAndOrderIsNull(Long appUser_id);

    //List<OrderLine> getOrderLinesWhereOrderIsNull();

}
