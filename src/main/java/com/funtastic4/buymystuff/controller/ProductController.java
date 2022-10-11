package com.funtastic4.buymystuff.controller;

import com.funtastic4.buymystuff.Dto.AddProductDto;
import com.funtastic4.buymystuff.Dto.ProductDto;

import com.funtastic4.buymystuff.enums.Role;
import com.funtastic4.buymystuff.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping(value = "",produces = "application/json")
//    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
//        ProductDto newProductDto = productService.createProduct(productDto);
//        return new ResponseEntity<>(newProductDto, HttpStatus.CREATED);
//    }

    @PostMapping(value = "",produces = "application/json")
    public ResponseEntity<ProductDto> addProduct(@RequestBody AddProductDto addProductDto) {
        ProductDto productDto = productService.createProduct(addProductDto);
        return new ResponseEntity<>(productDto, HttpStatus.CREATED);
    }

    @GetMapping(value = "{productId}", produces = "application/json")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("productId") Long id) {
        ProductDto productDto = productService.findProductById(id);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @GetMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> productDtoList = productService.findAllProducts();
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

//    @GetMapping(value = "{categoryId}", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<List<ProductDto>> getAllProductsByCategory(@PathVariable("categoryId") Long id) {
//        List<ProductDto> productDtoList = productService.findProductsByCategory(id);
//        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
//    }

    @PutMapping(value = "{productId}", produces = "application/json")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("productId") Long id, @RequestBody ProductDto productDto) {
        ProductDto newProductDto = productService.updateProduct(id, productDto);
        return new ResponseEntity<>(newProductDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "{productId}", produces = "application/json")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
