package com.funtastic4.buymystuff.service;

import com.funtastic4.buymystuff.Dto.AddOrderLineDto;
import com.funtastic4.buymystuff.Dto.OrderLineDto;
import com.funtastic4.buymystuff.mapper.AddOrderLineMapper;
import com.funtastic4.buymystuff.mapper.OrderLineMapper;
import com.funtastic4.buymystuff.model.OrderLine;
import com.funtastic4.buymystuff.repository.OrderLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;
    private final OrderLineMapper orderLineMapper;
    private final AddOrderLineMapper addOrderLineMapper;

    public OrderLineService(OrderLineRepository orderLineRepository, OrderLineMapper orderLineMapper, AddOrderLineMapper addOrderLineMapper) {
        this.orderLineRepository = orderLineRepository;
        this.orderLineMapper = orderLineMapper;
        this.addOrderLineMapper = addOrderLineMapper;
    }

    public List<OrderLineDto> getAllOrderLines() {
        return orderLineRepository.findAll().stream().map(orderLineMapper::convertToDto).collect(Collectors.toList());
    }

    public OrderLineDto createOrderLine(AddOrderLineDto addOrderLineDto) {
        OrderLine orderLine = addOrderLineMapper.convertToEntity(addOrderLineDto);
        orderLineRepository.save(orderLine);
        return orderLineMapper.convertToDto(orderLine);
    }

    public OrderLineDto updateOrderLine(Long id, Integer quantity) {
        OrderLine orderLine = orderLineRepository.getReferenceById(id);
        orderLine.setQuantity(quantity);
        orderLineRepository.save(orderLine);
        return orderLineMapper.convertToDto(orderLine);
    }

    public void deleteOrderLine(Long id) {
        orderLineRepository.deleteById(id);
    }


}
