package com.funtastic4.buymystuff.Dto;

import com.funtastic4.buymystuff.enums.ProductType;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private byte[] imageFile;
    private Double price;
    private ProductType productType;
    private ProducerDto producerDto; // this will go to the frontend to be displayed
    private CategoryDto categoryDto; // this will go to the frontend to be displayed

}

