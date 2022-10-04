package com.funtastic4.buymystuff.mapper;

import com.funtastic4.buymystuff.Dto.ProductDto;
import com.funtastic4.buymystuff.model.Product;
import com.funtastic4.buymystuff.repository.CategoryRepository;
import com.funtastic4.buymystuff.repository.ProducerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductMapper implements Mapper<Product, ProductDto> {
    private final ProducerMapper producerMapper;
    private final CategoryMapper categoryMapper;

    private final ProducerRepository producerRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public ProductDto convertToDto(Product entity) {
        ProductDto productDto = new ProductDto();

        productDto.setId(entity.getId());
        productDto.setName(entity.getName());
        productDto.setDescription(entity.getDescription());
        productDto.setImageUrl(entity.getImageUrl());
        productDto.setPrice(entity.getPrice());
        productDto.setProductType(entity.getProductType());
        productDto.setProducerDto(producerMapper.convertToDto(entity.getProducer()));
        productDto.setCategoryDto(categoryMapper.convertToDto(entity.getCategory()));

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
        product.setProducer(producerRepository.getReferenceById(dto.getProducerDto().getId()));
        product.setCategory(categoryRepository.getReferenceById(dto.getCategoryDto().getId()));

        return product;
    }
}
