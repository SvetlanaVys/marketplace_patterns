package com.svysk.marketplace.controller;

import com.svysk.marketplace.dto.ProductDTO;
import com.svysk.marketplace.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/all")
    List<ProductDTO> findProducts() {
        return service.getAll();
    }

    @GetMapping("/by_category/{categoryId}")
    List<ProductDTO> findProductByCategory(@PathVariable("categoryId") Long categoryId) {
        return service.getProductByCategory(categoryId);
    }

    @GetMapping("/{id}")
    ProductDTO findProductById(@PathVariable("id") Long id) {
        return service.getProductById(id);
    }

    @PostMapping("/add")
    ProductDTO saveProduct(@RequestBody ProductDTO newProduct) {
        return service.save(newProduct);
    }

    @DeleteMapping("/delete/{id}")
    boolean deleteProduct(@PathVariable("id") Long id) {
        return service.delete(id);
    }

}
