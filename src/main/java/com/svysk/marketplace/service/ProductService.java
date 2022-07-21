package com.svysk.marketplace.service;

import com.svysk.marketplace.dto.ProductDTO;
import com.svysk.marketplace.mapper.ProductMapper;
import com.svysk.marketplace.model.Category;
import com.svysk.marketplace.model.Product;
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


    public List<ProductDTO> getAll() {
        List<Product> products = repository.getAll();
        return products.stream()
                .map(ProductMapper::toProductDTO)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductByCategory(Long categoryId) {
        List<Product> products = repository.getProductByCategory(categoryId);
        return products.stream()
                .map(ProductMapper::toProductDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(Long id) {
        Product product = repository.getProductById(id);
        return ProductMapper.toProductDTO(product);
    }

    public ProductDTO save(ProductDTO newProduct) {
        Product product = ProductMapper.toProduct(newProduct);
        Category category = categoryRepository.getCategoryById(newProduct.getCategoryId());
        product.setCategory(category);
        product = repository.save(product);
        return ProductMapper.toProductDTO(product);
    }


    public boolean delete(Long id) {
        Product product = repository.getProductById(id);
        repository.delete(product);
        return true;
    }
}