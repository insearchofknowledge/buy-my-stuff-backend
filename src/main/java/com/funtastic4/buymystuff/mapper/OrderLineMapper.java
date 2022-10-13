package com.funtastic4.buymystuff.mapper;

import com.funtastic4.buymystuff.Dto.OrderLineDto;
import com.funtastic4.buymystuff.model.OrderLine;
import com.funtastic4.buymystuff.model.Product;
import com.funtastic4.buymystuff.repository.ProductRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderLineMapper implements Mapper<OrderLine, OrderLineDto> {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public OrderLineMapper(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public OrderLineDto convertToDto(OrderLine entity) {
        OrderLineDto orderLineDto = new OrderLineDto();
        orderLineDto.setId(entity.getId());
        orderLineDto.setProductPrice(entity.getProductPrice());
        orderLineDto.setNumberOfProducts(entity.getNumberOfProducts());
        if (entity.getProduct() != null) {
            orderLineDto.setProductDto(productMapper.convertToDto(productRepository.getReferenceById(entity.getProduct().getId())));
        }
        return orderLineDto;
    }

    @Override
    public OrderLine convertToEntity(OrderLineDto dto) {
        OrderLine orderLine = new OrderLine();
        orderLine.setId(dto.getId());
        Optional<Product> product = productRepository.findById(dto.getProductDtoId());
        if (product.isPresent()) {
            orderLine.setProduct(product.get());
        }
        orderLine.setProductPrice(dto.getProductPrice());
        orderLine.setNumberOfProducts(dto.getNumberOfProducts());
        return orderLine;
    }
}
