package com.svysk.marketplace.service;

import com.svysk.marketplace.dto.BrandDTO;
import com.svysk.marketplace.mapper.BrandMapper;
import com.svysk.marketplace.model.Brand;
import com.svysk.marketplace.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BrandService {

    @Autowired
    BrandRepository repository;

    public BrandDTO save(BrandDTO newBrand) {
        Brand brand = BrandMapper.toBrand(newBrand);
        brand = repository.save(brand);
        return BrandMapper.toBrandDTO(brand);
    }

    public boolean delete(Long id) {
        Brand brand = repository.getBrandById(id);
        repository.delete(brand);
        return true;
    }
}
