package com.funtastic4.buymystuff.service;

import com.funtastic4.buymystuff.Dto.AddOrderLineDto;
import com.funtastic4.buymystuff.Dto.OrderLineDto;
import com.funtastic4.buymystuff.mapper.AddOrderLineMapper;
import com.funtastic4.buymystuff.mapper.OrderLineMapper;
import com.funtastic4.buymystuff.model.OrderLine;
import com.funtastic4.buymystuff.model.Product;
import com.funtastic4.buymystuff.repository.OrderLineRepository;
import com.funtastic4.buymystuff.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;
    private final OrderLineMapper orderLineMapper;
    private final AddOrderLineMapper addOrderLineMapper;
    private final ProductRepository productRepository;

    public OrderLineService(OrderLineRepository orderLineRepository, OrderLineMapper orderLineMapper, AddOrderLineMapper addOrderLineMapper, ProductRepository productRepository) {
        this.orderLineRepository = orderLineRepository;
        this.orderLineMapper = orderLineMapper;
        this.addOrderLineMapper = addOrderLineMapper;
        this.productRepository = productRepository;
    }

    public List<OrderLineDto> getAllOrderLines() {
        return orderLineRepository.findAll().stream().map(orderLineMapper::convertToDto).collect(Collectors.toList());
    }

    public OrderLineDto createOrderLine(AddOrderLineDto addOrderLineDto) {
        Product productToBeAdded = productRepository.getReferenceById(addOrderLineDto.getProductDto());
        Optional<OrderLine> alreadyExistingOrderLine = orderLineRepository.getOrderLineByAppUserIdAndProductAndOrderIsNull(addOrderLineDto.getAppUserDto(), productToBeAdded);
        if (alreadyExistingOrderLine.isPresent()) {
            OrderLine existingOrderLine = alreadyExistingOrderLine.get();
            existingOrderLine.setQuantity(existingOrderLine.getQuantity()+1);
            orderLineRepository.save(existingOrderLine);
            return orderLineMapper.convertToDto(existingOrderLine);
        }
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
