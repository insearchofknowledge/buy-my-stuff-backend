package com.funtastic4.buymystuff.service;

import com.funtastic4.buymystuff.Dto.OrderDto;
import com.funtastic4.buymystuff.mapper.OrderMapper;
import com.funtastic4.buymystuff.model.Order;
import com.funtastic4.buymystuff.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public OrderDto createOrder(OrderDto orderDto){
        Order order = orderMapper.convertToEntity(orderDto);
        orderRepository.save(order);
        return orderMapper.convertToDto(order);
    }
}
