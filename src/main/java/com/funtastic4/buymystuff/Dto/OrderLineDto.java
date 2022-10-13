package com.funtastic4.buymystuff.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderLineDto {

    private Long id;
    private Integer numberOfProducts;
    private Double productPrice;
    private ProductDto productDto;
    private Long productDtoId;
}
