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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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

    @PostMapping(value = "", produces = "application/json")
    public ResponseEntity<ProductDto> addProduct(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("price") Double price,
            @RequestParam("categoryDto") Long categoryDto,
            @RequestParam("producerDto") Long producerDto,   // this is only the ID coming from the frontend
            @RequestParam("productType") int productType,
            @RequestParam("imageFile") MultipartFile imageFile
    ) throws IOException {
        AddProductDto addProductDto = new AddProductDto();
        addProductDto.setName(name);
        addProductDto.setDescription(description);
        addProductDto.setPrice(price);
        addProductDto.setCategoryDto(categoryDto);
        addProductDto.setProducerDto(producerDto);
        addProductDto.setProductType(productType);
        addProductDto.setImageFile(imageFile.getBytes());

        ProductDto productDto = productService.createProduct(addProductDto);
        return new ResponseEntity<>(productDto, HttpStatus.CREATED);
    }

    @GetMapping(value = "{productId}", produces = "application/json")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("productId") Long id) {
        ProductDto productDto = productService.findProductById(id);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> productDtoList = productService.findAllProducts();
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

//    @GetMapping(value = "{categoryId}", produces = "application/json")
//    public ResponseEntity<List<ProductDto>> getAllProductsByCategory(@PathVariable("categoryId") Long id) {
//        List<ProductDto> productDtoList = productService.findProductsByCategory(id);
//        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
//    }

    @PutMapping(value = "{productId}")
    public ResponseEntity<ProductDto> updateProduct(
            @PathVariable("productId") Long id,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("price") Double price,
            @RequestParam("categoryDto") Long categoryDto,
            @RequestParam("producerDto") Long producerDto,   // this is only the ID coming from the frontend
            @RequestParam("productType") int productType,
            @RequestParam("imageFile") Optional<MultipartFile> imageFileOptional
    ) throws IOException {
        AddProductDto updateProductDto = new AddProductDto();
        updateProductDto.setName(name);
        updateProductDto.setDescription(description);
        updateProductDto.setPrice(price);
        updateProductDto.setCategoryDto(categoryDto);
        updateProductDto.setProducerDto(producerDto);
        updateProductDto.setProductType(productType);
        if (imageFileOptional.isPresent()) {
            MultipartFile imageFile = imageFileOptional.get();
            updateProductDto.setImageFile(imageFile.getBytes());
        }

        ProductDto newProductDto = productService.updateProduct(id, updateProductDto);
        return new ResponseEntity<>(newProductDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "{productId}", produces = "application/json")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
