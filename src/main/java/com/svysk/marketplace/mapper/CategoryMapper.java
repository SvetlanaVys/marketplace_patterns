package com.svysk.marketplace.mapper;

import com.svysk.marketplace.dto.CategoryDTO;
import com.svysk.marketplace.model.Category;

public class CategoryMapper {
    private static CategoryMapper instance;

    private CategoryMapper() {
    }

    public static CategoryMapper getInstance() {
        if(instance == null) {
            instance = new CategoryMapper();
        }
        return instance;
    }

    public CategoryDTO toCategoryDTO(Category category) {
        return new CategoryDTO.Builder()
                .buildId(category.getId())
                .buildCategoryName(category.getCategoryName())
                .build();
    }

    public Category toCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setCategoryName(categoryDTO.getCategoryName());
        return category;
    }
}
