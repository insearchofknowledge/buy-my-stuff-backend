package com.funtastic4.buymystuff.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddOrderLineDto {

    private Long id;
    private Integer quantity;
    private Double productPrice;
    private Long productDto;
    private Long appUserDto;
}
