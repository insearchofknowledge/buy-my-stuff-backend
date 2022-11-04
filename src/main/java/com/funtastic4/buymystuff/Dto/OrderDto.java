package com.funtastic4.buymystuff.Dto;

import com.funtastic4.buymystuff.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderDto {

    private Long orderId;
    private LocalDateTime orderDate;
    private String deliveryAddress;
    private OrderStatus orderStatus;
    private List<OrderLineDto> orderLineDtoList;
    private AppUserDto appUserDto;
    private Double totalCost;

}
