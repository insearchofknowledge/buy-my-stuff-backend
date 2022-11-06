package com.funtastic4.buymystuff.Dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineDto {

    private Long id;
    private Integer quantity;
    private Double productPrice;
    private Double totalPrice;
    private ProductDto productDto;
    private AppUserDto appUserDto;
}
