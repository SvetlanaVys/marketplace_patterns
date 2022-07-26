package com.svysk.marketplace.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

@Getter
public class CategoryDTO {
    @JsonIgnore
    Long id;
    String categoryName;

    public static class Builder {
        private CategoryDTO categoryDTO;

        public Builder() {
            categoryDTO = new CategoryDTO();
        }

        public Builder buildId(Long id) {
            categoryDTO.id = id;
            return this;
        }

        public Builder buildCategoryName(String categoryName) {
            categoryDTO.categoryName = categoryName;
            return this;
        }

        public CategoryDTO build() {
            return categoryDTO;
        }
    }
}
