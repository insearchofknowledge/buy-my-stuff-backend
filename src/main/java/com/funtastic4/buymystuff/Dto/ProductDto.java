package com.funtastic4.buymystuff.Dto;

import com.funtastic4.buymystuff.enums.ProductType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private Double price;
    private ProductType productType;
    private ProducerDto producerDto;
    private CategoryDto categoryDto;

    public ProductDto() {
    }

    public ProductDto(Long id, String name, String description, String imageUrl, Double price, ProductType productType, ProducerDto producerDto, CategoryDto categoryDto) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.productType = productType;
        this.producerDto = producerDto;
        this.categoryDto = categoryDto;
    }
}

