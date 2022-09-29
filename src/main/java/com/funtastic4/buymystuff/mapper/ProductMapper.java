package com.funtastic4.buymystuff.mapper;

import com.funtastic4.buymystuff.Dto.ProductDto;
import com.funtastic4.buymystuff.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper implements Mapper<Product, ProductDto> {
    @Override
    public ProductDto convertToDto(Product entity) {
        ProductDto productDto = new ProductDto();

        productDto.setId(entity.getId());
        productDto.setName(entity.getName());
        productDto.setDescription(entity.getDescription());
        productDto.setImageUrl(entity.getImageUrl());
        productDto.setPrice(entity.getPrice());
        productDto.setProductType(entity.getProductType());
        productDto.setProducer(entity.getProducer());
        productDto.setCategory(entity.getCategory());

        return productDto;
    }

    @Override
    public Product convertToEntity(ProductDto dto) {
        Product product = new Product();

        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setImageUrl(dto.getImageUrl());
        product.setPrice(dto.getPrice());
        product.setProductType(dto.getProductType());
        product.setProducer(dto.getProducer());
        product.setCategory(dto.getCategory());

        return product;
    }
}
