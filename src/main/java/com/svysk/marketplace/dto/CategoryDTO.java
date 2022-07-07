package com.svysk.marketplace.dto;

import lombok.Data;

@Data
public class CategoryDTO {
    Long id;
    String categoryName;

    public CategoryDTO buildId(Long id) {
        this.id = id;
        return this;
    }

    public CategoryDTO buildCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public CategoryDTO build() {
        return this;
    }
}
