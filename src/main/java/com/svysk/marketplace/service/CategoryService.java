package com.svysk.marketplace.service;

import com.svysk.marketplace.dto.CategoryDTO;
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
                .map(category -> new CategoryDTO()
                        .buildId(category.getId())
                        .buildCategoryName(category.getCategoryName())
                        .build())
                .collect(Collectors.toList());


    }

    public CategoryDTO getCategoryById(Long id) {
        Category category = repository.getCategoryById(id);
        return new CategoryDTO()
                .buildId(category.getId())
                .buildCategoryName(category.getCategoryName())
                .build();
    }

    public List<CategoryDTO> getCategoriesByCategoryName(String name) {
        List<Category> categories = repository.getCategoriesByCategoryName(name);
        return categories.stream()
                .map(category -> new CategoryDTO()
                        .buildId(category.getId())
                        .buildCategoryName(category.getCategoryName())
                        .build())
                .collect(Collectors.toList());
    }
}
