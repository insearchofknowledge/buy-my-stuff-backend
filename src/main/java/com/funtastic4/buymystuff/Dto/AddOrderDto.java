package com.funtastic4.buymystuff.Dto;

import com.funtastic4.buymystuff.enums.OrderStatus;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddOrderDto {

    private Long orderId;
    private String deliveryAddress;
    private List<Long> orderLineDtoList;
    private Long appUserDto;
}
