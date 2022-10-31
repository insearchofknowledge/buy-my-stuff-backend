package com.funtastic4.buymystuff.mapper;

import com.funtastic4.buymystuff.Dto.OrderDto;
import com.funtastic4.buymystuff.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper implements Mapper<Order, OrderDto>{
    @Override
    public OrderDto convertToDto(Order entity) {
        return null;
    }

    @Override
    public Order convertToEntity(OrderDto dto) {
        return null;
    }
}
