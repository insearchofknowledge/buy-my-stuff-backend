package com.funtastic4.buymystuff.service;

import com.funtastic4.buymystuff.Dto.AddProductDto;
import com.funtastic4.buymystuff.Dto.ProductDto;
import com.funtastic4.buymystuff.enums.ProductType;
import com.funtastic4.buymystuff.mapper.AddProductMapper;
import com.funtastic4.buymystuff.mapper.ProductMapper;
import com.funtastic4.buymystuff.model.Product;
import com.funtastic4.buymystuff.repository.CategoryRepository;
import com.funtastic4.buymystuff.repository.ProducerRepository;
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

    private final ProducerRepository producerRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final AddProductMapper addProductMapper;

    public ProductService(ProducerRepository producerRepository, CategoryRepository categoryRepository, ProductRepository productRepository, ProductMapper productMapper, AddProductMapper addProductMapper) {
        this.producerRepository = producerRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.addProductMapper = addProductMapper;
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

    public ProductDto createProduct2(ProductDto productDto) {
        checkProductName(productDto.getName());
        Product product = productMapper.convertToEntity(productDto);
        productRepository.save(product);
        return productMapper.convertToDto(product);
    }

    public ProductDto createProduct(AddProductDto addProductDto) {
        checkProductName(addProductDto.getName());
        Product product = addProductMapper.convertToEntity(addProductDto);
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

    public ProductDto updateProduct(Long id, AddProductDto productDto) {
        Product originalProduct = getProduct(id);
        originalProduct.setName(productDto.getName());
        originalProduct.setDescription(productDto.getDescription());
        if (productDto.getImageFile() != null) {                     // we need this if statement in case no picture comes from fronted
            originalProduct.setImageFile(productDto.getImageFile()); // without this if no picture comes then the old picture will be removed
        }
        originalProduct.setPrice(productDto.getPrice());
        originalProduct.setProductType(ProductType.values()[productDto.getProductType()]);
        originalProduct.setProducer(producerRepository.getReferenceById(productDto.getProducerDto()));
        originalProduct.setCategory(categoryRepository.getReferenceById(productDto.getCategoryDto()));
        // checkProductName(productDto.getName());
        productRepository.save(originalProduct);
        return productMapper.convertToDto(originalProduct);
    }

    public void deleteProduct(Long id) {
        getProduct(id);
        productRepository.deleteById(id);
    }
}
