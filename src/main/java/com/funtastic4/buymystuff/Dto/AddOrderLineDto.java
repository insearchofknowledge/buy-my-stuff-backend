package com.funtastic4.buymystuff.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddOrderLineDto {

    private Long id;
    private Integer quantity;
    private Double productPrice;
    private Long productDto;
    private Long appUserDto;
}