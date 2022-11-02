package com.funtastic4.buymystuff.mapper;

import com.funtastic4.buymystuff.Dto.AddOrderLineDto;
import com.funtastic4.buymystuff.model.OrderLine;
import com.funtastic4.buymystuff.repository.AppUserRepository;
import com.funtastic4.buymystuff.repository.OrderLineRepository;
import com.funtastic4.buymystuff.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class AddOrderLineMapper implements Mapper<OrderLine, AddOrderLineDto> {
    private final OrderLineRepository orderLineRepository;
    private final ProductRepository productRepository;
    private final AppUserRepository appUserRepository;

    public AddOrderLineMapper(OrderLineRepository orderLineRepository, ProductRepository productRepository, AppUserRepository appUserRepository) {
        this.orderLineRepository = orderLineRepository;
        this.productRepository = productRepository;
        this.appUserRepository = appUserRepository;
    }


        @Override
    public AddOrderLineDto convertToDto(OrderLine entity) {
        return null;
    }

    @Override
    public OrderLine convertToEntity(AddOrderLineDto dto) {
        OrderLine orderLine = new OrderLine();
        orderLine.setQuantity(dto.getQuantity());
        orderLine.setProductPrice(productRepository.getReferenceById(dto.getProductDto()).getPrice());
        orderLine.setProduct(productRepository.getReferenceById(dto.getProductDto()));
        orderLine.setAppUser(appUserRepository.getReferenceById(dto.getAppUserDto()));
        // order is null should be changed when order is placed

        return orderLine;
    }
}
