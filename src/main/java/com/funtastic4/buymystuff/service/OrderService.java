package com.funtastic4.buymystuff.service;

import com.funtastic4.buymystuff.Dto.AddOrderDto;
import com.funtastic4.buymystuff.Dto.OrderDto;
import com.funtastic4.buymystuff.mapper.AddOrderMapper;
import com.funtastic4.buymystuff.mapper.OrderMapper;
import com.funtastic4.buymystuff.model.Order;
import com.funtastic4.buymystuff.model.OrderLine;
import com.funtastic4.buymystuff.repository.OrderLineRepository;
import com.funtastic4.buymystuff.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderLineRepository orderLineRepository;
    private final OrderMapper orderMapper;
    private final AddOrderMapper addOrderMapper;

    public OrderService(OrderRepository orderRepository, OrderLineRepository orderLineRepository, OrderMapper orderMapper, AddOrderMapper addOrderMapper) {
        this.orderRepository = orderRepository;
        this.orderLineRepository = orderLineRepository;
        this.orderMapper = orderMapper;
        this.addOrderMapper = addOrderMapper;
    }

    public OrderDto createOrder(AddOrderDto addOrderDto) {
        Order order = addOrderMapper.convertToEntity(addOrderDto);
        List<OrderLine> orderLinesList = new ArrayList<>();
        orderRepository.save(order);
        for (Long orderLineId : addOrderDto.getOrderLineDtoList()) {
            OrderLine orderLine = orderLineRepository.getReferenceById(orderLineId);
            orderLine.setOrder(order);
            orderLinesList.add(orderLine);
            orderLineRepository.save(orderLine);
        }
        order.setOrderLines(orderLinesList);
        order.setTotalCost(order.calculateTotalCost());
        orderRepository.save(order);

        return orderMapper.convertToDto(order);
    }
}