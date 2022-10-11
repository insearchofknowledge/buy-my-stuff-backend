package com.funtastic4.buymystuff.Dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AddProductDto {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long categoryDto;   // this is only the ID coming from the frontend
    private Long producerDto;   // this is only the ID coming from the frontend
    private int productType;

}
