 package com.svysk.marketplace.mapper;


import com.svysk.marketplace.dto.ProductDTO;
import com.svysk.marketplace.model.Category;
import com.svysk.marketplace.model.Product;

public class ProductMapper {
    private static volatile ProductMapper instance;

    private ProductMapper() {
    }

    public static ProductMapper getInstance() {
        if(instance == null) {
            synchronized (ProductMapper.class) {
                if(instance == null) {
                    instance = new ProductMapper();
                }
            }
        }

        return instance;
    }

    public ProductDTO toProductDTO(Product product) {
        return new ProductDTO.Builder()
                .buildId(product.getId())
                .buildName(product.getName())
                .buildCategoryId(product.getCategory().getId())
                .buildBrand(product.getBrand())
                .buildPrice(product.getPrice())
                .build();
    }

    public Product toProduct(ProductDTO productDTO, Category category) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setCategory(category);
        product.setName(productDTO.getName());
        product.setBrand(productDTO.getBrand());
        product.setPrice(productDTO.getPrice());
        return product;
    }
}
