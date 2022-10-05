package com.funtastic4.buymystuff.controller;

import com.funtastic4.buymystuff.Dto.CategoryDto;
import com.funtastic4.buymystuff.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(value = "", produces = "application/json")
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto newCategoryDto = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(newCategoryDto, HttpStatus.CREATED);
    }

    @GetMapping(value = "{categoryId}", produces = "application/json")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable("categoryId") Long id) {
        CategoryDto categoryDto = categoryService.findCategoryById(id);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categoryDtoList = categoryService.findAllCategories();
        return new ResponseEntity<>(categoryDtoList, HttpStatus.OK);
    }

    @PutMapping(value = "{categoryId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("categoryId") Long id, @RequestBody CategoryDto categoryDto) {
        CategoryDto newCategoryDto = categoryService.updateCategory(id, categoryDto);
        return new ResponseEntity<>(newCategoryDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "{categoryId})", produces = "application/json")
    public ResponseEntity<?> deleteCategory(@PathVariable("categoryId") Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    public String handleExceptions(EntityNotFoundException exception){
        log.error(exception.getMessage(),exception);
        return exception.getMessage();
    }
}
