package com.funtastic4.buymystuff.mapper;

import com.funtastic4.buymystuff.Dto.OrderLineDto;
import com.funtastic4.buymystuff.model.OrderLine;
import com.funtastic4.buymystuff.model.Product;
import com.funtastic4.buymystuff.repository.AppUserRepository;
import com.funtastic4.buymystuff.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderLineMapper implements Mapper<OrderLine, OrderLineDto> {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final AppUserMapper appUserMapper;
    private final AppUserRepository appUserRepository;

    public OrderLineMapper(ProductRepository productRepository, ProductMapper productMapper, AppUserMapper appUserMapper, AppUserRepository appUserRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.appUserMapper = appUserMapper;
        this.appUserRepository = appUserRepository;
    }

    @Override
    public OrderLineDto convertToDto(OrderLine entity) {
        OrderLineDto orderLineDto = new OrderLineDto();
        orderLineDto.setId(entity.getId());
        orderLineDto.setProductPrice(entity.getProductPrice());
        orderLineDto.setQuantity(entity.getQuantity());
        if (entity.getProduct() != null) {
            orderLineDto.setProductDto(productMapper.convertToDto(productRepository.getReferenceById(entity.getProduct().getId())));
        }
        orderLineDto.setTotalPrice(entity.getTotalPrice());
        orderLineDto.setAppUserDto(appUserMapper.convertToDto(appUserRepository.getReferenceById(entity.getAppUser().getId())));
        return orderLineDto;
    }

    @Override
    public OrderLine convertToEntity(OrderLineDto dto) {
        OrderLine orderLine = new OrderLine();
        orderLine.setId(dto.getId());
        Optional<Product> product = productRepository.findById(dto.getProductDto().getId());
        if (product.isPresent()) {
            orderLine.setProduct(product.get());
        }
        orderLine.setProductPrice(dto.getProductPrice());
        orderLine.setQuantity(dto.getQuantity());
        return orderLine;
    }
}
