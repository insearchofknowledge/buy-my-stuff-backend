package com.funtastic4.buymystuff.service;

import com.funtastic4.buymystuff.model.Product;
import com.funtastic4.buymystuff.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {


    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Optional<Product> findProductById(long id){
        return productRepository.findById(id);
    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> findProductsByCategory(Long id){
        return productRepository.findProductByCategoryId(id);
    }

    public Product updateProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
