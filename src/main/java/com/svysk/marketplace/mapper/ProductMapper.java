 package com.svysk.marketplace.mapper;


import com.svysk.marketplace.dto.ProductDTO;
import com.svysk.marketplace.model.Brand;
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
                .buildBrand(product.getBrand().getId())
                .buildPrice(product.getPrice())
                .build();
    }

    public Product toProduct(ProductDTO productDTO, Category category, Brand brand) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCategory(category);
        product.setBrand(brand);
        product.setPrice(productDTO.getPrice());
        return product;
    }
}
