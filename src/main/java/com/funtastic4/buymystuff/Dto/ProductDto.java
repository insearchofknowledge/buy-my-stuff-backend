package com.funtastic4.buymystuff.Dto;

import com.funtastic4.buymystuff.enums.ProductType;
import com.funtastic4.buymystuff.model.Category;
import com.funtastic4.buymystuff.model.Producer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private Double price;
    private ProductType productType;
    private Producer producer;
    private Category category;

    public ProductDto() {
    }

    public ProductDto(Long id, String name, String description, String imageUrl, Double price, ProductType productType, Producer producer, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.productType = productType;
        this.producer = producer;
        this.category = category;
    }
}

