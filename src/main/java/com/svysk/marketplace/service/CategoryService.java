package com.svysk.marketplace.service;

import com.svysk.marketplace.dto.CategoryDTO;
import com.svysk.marketplace.mapper.CategoryMapper;
import com.svysk.marketplace.model.Category;
import com.svysk.marketplace.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    public List<CategoryDTO> getAll() {
        List<Category> categories = repository.getAll();
        return categories.stream()
                .map(CategoryMapper::toCategoryDTO)
                .collect(Collectors.toList());
    }

    public CategoryDTO getCategoryById(Long id) {
        Category category = repository.getCategoryById(id);
        return CategoryMapper.toCategoryDTO(category);
    }

    public List<CategoryDTO> getCategoriesByCategoryName(String name) {
        List<Category> categories = repository.getCategoriesByCategoryName(name);
        return categories.stream()
                .map(CategoryMapper::toCategoryDTO)
                .collect(Collectors.toList());
    }

    public CategoryDTO update(CategoryDTO newCategory, Long id) {
        Category updatedCategory = repository.getCategoryById(id);
        Category oldCategory;

        if(updatedCategory != null) {
            oldCategory = (Category) updatedCategory.copy();
            updatedCategory.setCategoryName(newCategory.getCategoryName());
            repository.save(updatedCategory);
            return CategoryMapper.toCategoryDTO(oldCategory);
        } else {
            updatedCategory = CategoryMapper.toCategory(newCategory);
            updatedCategory.setId(id);
            repository.save(updatedCategory);
        }

        return null;
    }
}
