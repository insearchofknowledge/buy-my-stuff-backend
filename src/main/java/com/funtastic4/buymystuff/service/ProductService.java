package com.funtastic4.buymystuff.service;

import com.funtastic4.buymystuff.Dto.ProductDto;
import com.funtastic4.buymystuff.mapper.ProductMapper;
import com.funtastic4.buymystuff.model.Product;
import com.funtastic4.buymystuff.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductService {


    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Product getProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Product with id %s doesn't exist.", id)));
        return product;
    }

    public void checkProductName(String name) {
        Optional<Product> product = productRepository.findProductByName(name);
        if (product.isPresent()) {
            throw new IllegalStateException(String.format("Product with name %s already exists.", name));
        }
    }

    public ProductDto createProduct(ProductDto productDto) {
        checkProductName(productDto.getName());
        Product product = productMapper.convertToEntity(productDto);
        productRepository.save(product);
        return productMapper.convertToDto(product);
    }

    public ProductDto findProductById(Long id) {
        Product product = getProduct(id);
        return productMapper.convertToDto(product);
    }

    public List<ProductDto> findAllProducts() {
        return productRepository.findAll().stream().map(productMapper::convertToDto).collect(Collectors.toList());
    }

    public List<ProductDto> findProductsByCategory(Long id) {
        return productRepository.findProductByCategoryId(id).stream().map(productMapper::convertToDto).collect(Collectors.toList());
    }

    public ProductDto updateProduct(Long id, ProductDto productDto) {
        getProduct(id);
        checkProductName(productDto.getName());
        Product newProduct = productMapper.convertToEntity(productDto);
        productRepository.save(newProduct);
        return productMapper.convertToDto(newProduct);
    }

    public void deleteProduct(Long id) {
        getProduct(id);
        productRepository.deleteById(id);
    }
}
