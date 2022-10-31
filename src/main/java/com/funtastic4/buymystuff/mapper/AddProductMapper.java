package com.funtastic4.buymystuff.mapper;

import com.funtastic4.buymystuff.Dto.AddProductDto;
import com.funtastic4.buymystuff.enums.ProductType;
import com.funtastic4.buymystuff.model.Product;
import com.funtastic4.buymystuff.repository.CategoryRepository;
import com.funtastic4.buymystuff.repository.ProducerRepository;
import org.springframework.stereotype.Service;

@Service
public class AddProductMapper implements Mapper<Product, AddProductDto> {

    private final ProducerRepository producerRepository;
    private final CategoryRepository categoryRepository;

    public AddProductMapper(ProducerRepository producerRepository, CategoryRepository categoryRepository) {
        this.producerRepository = producerRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public AddProductDto convertToDto(Product entity) {
        return null;
    }

    @Override
    public Product convertToEntity(AddProductDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        if (dto.getImageFile() != null) {
            product.setImageFile(dto.getImageFile());
        }
        product.setPrice(dto.getPrice());
        product.setProductType(ProductType.values()[dto.getProductType()]);
        product.setProducer(producerRepository.getReferenceById(dto.getProducerDto())); // .getProducerDto gets only the ID that is sent from the frontend
        product.setCategory(categoryRepository.getReferenceById(dto.getCategoryDto())); // .getCategoryDto gets only the ID that is sent from the frontend

        return product;
    }
}
