package com.svysk.marketplace.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

@Getter
public class ProductDTO {

    @JsonIgnore
    Long id;
    String name;
    Long categoryId;
    Long brandId;
    Float price;

    public static class Builder {
        private ProductDTO productDTO;

        public Builder() {
            productDTO = new ProductDTO();
        }

        public ProductDTO.Builder buildId(Long id) {
            productDTO.id = id;
            return this;
        }

        public ProductDTO.Builder buildName(String name) {
            productDTO.name = name;
            return this;
        }

        public ProductDTO.Builder buildCategoryId(Long categoryId) {
            productDTO.categoryId = categoryId;
            return this;
        }

        public ProductDTO.Builder buildBrand(Long brandId) {
            productDTO.brandId = brandId;
            return this;
        }

        public ProductDTO.Builder buildPrice(Float price) {
            productDTO.price = price;
            return this;
        }

        public ProductDTO build() {
            return productDTO;
        }
    }
}
