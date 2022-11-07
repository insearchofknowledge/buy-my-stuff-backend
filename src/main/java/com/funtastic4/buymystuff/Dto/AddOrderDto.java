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

    private Long id;
    private String county;
    private String city;
    private String street;
    private String zipCode;
    private String phoneNumber;
    private String additionalInformation;
    private List<Long> orderLineDtoList;
    private Long user;
}
