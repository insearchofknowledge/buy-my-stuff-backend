package com.funtastic4.buymystuff.mapper;

import com.funtastic4.buymystuff.Dto.OrderDto;
import com.funtastic4.buymystuff.model.Order;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@Service
public class OrderMapper implements Mapper<Order, OrderDto>{

    private final OrderLineMapper orderLineMapper;

    public OrderMapper(OrderLineMapper orderLineMapper) {
        this.orderLineMapper = orderLineMapper;
    }

    @Override
    public OrderDto convertToDto(Order entity) {
        OrderDto orderDto= new OrderDto();
        orderDto.setId(entity.getId());
        orderDto.setOrderDate(entity.getOrderDate().truncatedTo(ChronoUnit.SECONDS));
        orderDto.setCounty(entity.getCounty());
        orderDto.setCity(entity.getCity());
        orderDto.setStreet(entity.getStreet());
        orderDto.setZipCode(entity.getZipCode());
        orderDto.setPhoneNumber(entity.getPhoneNumber());
        orderDto.setOrderStatus(entity.getOrderStatus());
        orderDto.setTotalCost(entity.getTotalCost());
        orderDto.setAdditionalInformation(entity.getAdditionalInformation());
//        orderDto.setOrderLineDtoList(entity.getOrderLines().stream().map(orderLineMapper::convertToDto).collect(Collectors.toList()));
        return orderDto;
    }

    @Override
    public Order convertToEntity(OrderDto dto) {
        return null;
    }
}
