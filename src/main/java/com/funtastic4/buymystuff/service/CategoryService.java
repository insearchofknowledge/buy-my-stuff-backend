package com.funtastic4.buymystuff.service;

import com.funtastic4.buymystuff.model.Category;
import com.funtastic4.buymystuff.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public Optional<Category> findCategoryById(Long id){
        return categoryRepository.findById(id);
    }

    public List<Category> findAllCategories(){
        return categoryRepository.findAll();
    }

    public Category updateCategory(Category category){
        return categoryRepository.save(category);
    }

}
