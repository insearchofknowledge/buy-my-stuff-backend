package com.funtastic4.buymystuff.service;

import com.funtastic4.buymystuff.Dto.CategoryDto;
import com.funtastic4.buymystuff.mapper.CategoryMapper;
import com.funtastic4.buymystuff.model.Category;
import com.funtastic4.buymystuff.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public Category getCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Category with id %s doesn't exist", id)));
        return category;
    }

    public void checkCategoryName(String name) {
        Optional<Category> category = categoryRepository.findCategoryByName(name);
        if (category.isPresent()) {
            throw new IllegalStateException(String.format("Category with name %s already exists.", name));
        }
    }

    public CategoryDto createCategory(CategoryDto categoryDto) {
        checkCategoryName(categoryDto.getName());
        Category newCategory = categoryMapper.convertToEntity(categoryDto);
        categoryRepository.save(newCategory);
        return categoryMapper.convertToDto(newCategory);
    }

    public CategoryDto findCategoryById(Long id) {
        Category category = getCategory(id);
        return categoryMapper.convertToDto(category);
    }

    public List<CategoryDto> findAllCategories() {
        return categoryRepository.findAll().stream().map(categoryMapper::convertToDto).collect(Collectors.toList());
//      return categoryRepository.findAll().stream().map(e->categoryMapper.convertToDto(e)).collect(Collectors.toList());
    }

    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        Category category = getCategory(id);
        checkCategoryName(categoryDto.getName());
        category.setName(categoryDto.getName());
        categoryRepository.save(category);
        return categoryMapper.convertToDto(category);
    }

    public void deleteCategory(Long id) {
        getCategory(id);
        categoryRepository.deleteById(id);
    }

}
