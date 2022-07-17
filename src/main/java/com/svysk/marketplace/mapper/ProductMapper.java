 package com.svysk.marketplace.mapper;


import com.svysk.marketplace.dto.ProductDTO;
import com.svysk.marketplace.model.Product;

public class ProductMapper {
    public static ProductDTO toProductDTO(Product product) {
        return new ProductDTO.Builder()
                .buildId(product.getId())
                .buildName(product.getName())
                .buildCategoryId(product.getCategory().getId())
                .buildBrand(product.getBrand())
                .buildPrice(product.getPrice())
                .build();
    }

    public static Product toProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setBrand(productDTO.getBrand());
        product.setPrice(productDTO.getPrice());
        return product;
    }
}
