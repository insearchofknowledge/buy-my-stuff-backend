package com.funtastic4.buymystuff.mapper;

import com.funtastic4.buymystuff.Dto.CategoryDto;
import com.funtastic4.buymystuff.model.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper implements Mapper<Category, CategoryDto>{
    @Override
    public CategoryDto convertToDto(Category entity) {
        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId(entity.getId());
        categoryDto.setName(entity.getName());
        return categoryDto;
    }

    @Override
    public Category convertToEntity(CategoryDto dto) {
        Category category =new Category();

        category.setId(dto.getId());
        category.setName(dto.getName());

        return category;
    }
}
