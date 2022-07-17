package com.svysk.marketplace.controller;

import com.svysk.marketplace.dto.CategoryDTO;
import com.svysk.marketplace.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/category", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {

    @Autowired
    CategoryService service;

    @CrossOrigin
    @GetMapping("/all")
    List<CategoryDTO> findCategory() {
        return service.getAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    CategoryDTO findCategoryById(@PathVariable("id") Long id) {
        return service.getCategoryById(id);
    }

    @CrossOrigin
    @GetMapping("/name/{name}")
    List<CategoryDTO>  findCategoryByName(@PathVariable("name") String name) {
        return service.getCategoriesByCategoryName(name);
    }
}
