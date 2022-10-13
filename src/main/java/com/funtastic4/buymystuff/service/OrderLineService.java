package com.funtastic4.buymystuff.service;

import com.funtastic4.buymystuff.Dto.OrderLineDto;
import com.funtastic4.buymystuff.mapper.OrderLineMapper;
import com.funtastic4.buymystuff.model.OrderLine;
import com.funtastic4.buymystuff.repository.OrderLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;
    private final OrderLineMapper orderLineMapper;

    public OrderLineService(OrderLineRepository orderLineRepository, OrderLineMapper orderLineMapper) {
        this.orderLineRepository = orderLineRepository;
        this.orderLineMapper = orderLineMapper;
    }

    public List<OrderLineDto> getAllOrderLines() {
        return orderLineRepository.findAll().stream().map(orderLineMapper::convertToDto).collect(Collectors.toList());
    }

    public OrderLineDto createOrderLine(OrderLineDto orderLineDto) {
        OrderLine orderLine = orderLineMapper.convertToEntity(orderLineDto);
        orderLineRepository.save(orderLine);
        return orderLineMapper.convertToDto(orderLine);
    }

    public OrderLineDto updateOrderLine(Long id, OrderLineDto orderLineDto) {
        OrderLine orderLine = orderLineRepository.getReferenceById(id);
        orderLine.setNumberOfProducts(orderLineDto.getNumberOfProducts());
        orderLineRepository.save(orderLine);
        return orderLineMapper.convertToDto(orderLine);
    }

    public void deleteOrderLine(Long id) {
        orderLineRepository.deleteById(id);
    }


}
