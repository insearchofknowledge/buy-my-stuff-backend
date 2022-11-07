package com.funtastic4.buymystuff.mapper;

import com.funtastic4.buymystuff.Dto.OrderDto;
import com.funtastic4.buymystuff.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper implements Mapper<Order, OrderDto>{
    @Override
    public OrderDto convertToDto(Order entity) {
        OrderDto orderDto= new OrderDto();
        orderDto.setId(entity.getId());
        orderDto.setOrderDate(entity.getOrderDate());
        orderDto.setCounty(entity.getCounty());
        orderDto.setCity(entity.getCity());
        orderDto.setStreet(entity.getStreet());
        orderDto.setZipCode(entity.getZipCode());
        orderDto.setPhoneNumber(entity.getPhoneNumber());
        orderDto.setOrderStatus(entity.getOrderStatus());
        return orderDto;
    }

    @Override
    public Order convertToEntity(OrderDto dto) {
        return null;
    }
}
