package com.funtastic4.buymystuff.Dto;

import com.funtastic4.buymystuff.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddOrderDto {

    private Long orderId;
    private String deliveryAddress;
    private List<Long> orderLineDtoList;
    private Long appUserDto;
}
