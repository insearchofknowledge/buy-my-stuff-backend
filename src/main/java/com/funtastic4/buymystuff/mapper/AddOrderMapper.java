package com.funtastic4.buymystuff.mapper;

import com.funtastic4.buymystuff.Dto.AddOrderDto;
import com.funtastic4.buymystuff.enums.OrderStatus;
import com.funtastic4.buymystuff.model.Order;
import com.funtastic4.buymystuff.model.OrderLine;
import com.funtastic4.buymystuff.repository.AppUserRepository;
import com.funtastic4.buymystuff.repository.OrderLineRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddOrderMapper implements Mapper<Order, AddOrderDto> {

    private final OrderLineRepository orderLineRepository;
    private final AppUserRepository appUserRepository;

    public AddOrderMapper(OrderLineRepository orderLineRepository, AppUserRepository appUserRepository) {
        this.orderLineRepository = orderLineRepository;
        this.appUserRepository = appUserRepository;
    }

    @Override
    public AddOrderDto convertToDto(Order entity) {
        return null;
    }

    @Override
    public Order convertToEntity(AddOrderDto dto) {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setCounty(dto.getCounty());
        order.setCity(dto.getCity());
        order.setStreet(dto.getStreet());
        order.setZipCode(dto.getZipCode());
        order.setPhoneNumber(dto.getPhoneNumber());
        order.setAdditionalInformation(dto.getAdditionalInformation());
        order.setOrderStatus(OrderStatus.PLACED);
        order.setUser(appUserRepository.getReferenceById(dto.getUser()));

        return order;
    }
}
