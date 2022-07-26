package com.svysk.marketplace.controller;

import com.svysk.marketplace.dto.BrandDTO;
import com.svysk.marketplace.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/brand", produces = MediaType.APPLICATION_JSON_VALUE)
public class BrandController {

    @Autowired
    BrandService service;

    @PostMapping("/add")
    BrandDTO saveBrand(@RequestBody BrandDTO newBrand) {
        return service.save(newBrand);
    }

    @DeleteMapping("/delete/{id}")
    boolean deleteBrand(@PathVariable("id") Long id) {
        return service.delete(id);
    }
}
