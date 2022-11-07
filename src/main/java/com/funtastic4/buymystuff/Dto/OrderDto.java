package com.funtastic4.buymystuff.Dto;

import com.funtastic4.buymystuff.enums.OrderStatus;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private LocalDateTime orderDate;
    private String county;
    private String city;
    private String street;
    private String zipCode;
    private String phoneNumber;
    private String additionalInformation;
    private OrderStatus orderStatus;
    private List<OrderLineDto> orderLineDtoList;
    private AppUserDto user;
    private Double totalCost;

}
