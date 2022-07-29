package com.svysk.marketplace.service;

import com.svysk.marketplace.dto.ProductDTO;
import com.svysk.marketplace.mapper.ProductMapper;
import com.svysk.marketplace.model.Brand;
import com.svysk.marketplace.model.Category;
import com.svysk.marketplace.model.Product;
import com.svysk.marketplace.repository.BrandRepository;
import com.svysk.marketplace.repository.CategoryRepository;
import com.svysk.marketplace.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BrandRepository brandRepository;


    public List<ProductDTO> getAll() {
        List<Product> products = repository.getAll();
        return products.parallelStream()
                .map(ProductMapper.getInstance()::toProductDTO)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductByCategory(Long categoryId) {
        List<Product> products = repository.getProductByCategory(categoryId);
        return products.parallelStream()
                .map(ProductMapper.getInstance()::toProductDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(Long id) {
        Product product = repository.getProductById(id);
        return ProductMapper.getInstance().toProductDTO(product);
    }

    public ProductDTO save(ProductDTO newProduct) {
        Category category = categoryRepository.getCategoryById(newProduct.getCategoryId());
        Brand brand = brandRepository.getBrandById(newProduct.getBrandId());
        Product product = ProductMapper.getInstance().toProduct(newProduct, category, brand);
        product = repository.save(product);
        return ProductMapper.getInstance().toProductDTO(product);
    }


    public boolean delete(Long id) {
        Product product = repository.getProductById(id);
        repository.delete(product);
        return true;
    }
}
