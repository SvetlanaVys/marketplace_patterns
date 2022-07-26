 package com.svysk.marketplace.mapper;


import com.svysk.marketplace.dto.ProductDTO;
import com.svysk.marketplace.model.Product;
import com.svysk.marketplace.repository.BrandRepository;
import com.svysk.marketplace.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductMapper {
    private static volatile ProductMapper instance;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BrandRepository brandRepository;

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

    public Product toProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCategory(categoryRepository.getCategoryById(productDTO.getCategoryId()));
        product.setBrand(brandRepository.getBrandById(productDTO.getBrandId()));
        product.setPrice(productDTO.getPrice());
        return product;
    }
}
