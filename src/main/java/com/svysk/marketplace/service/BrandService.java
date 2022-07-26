package com.svysk.marketplace.service;

import com.svysk.marketplace.dto.BrandDTO;
import com.svysk.marketplace.mapper.BrandMapper;
import com.svysk.marketplace.model.Brand;
import com.svysk.marketplace.pattern_extra.decorator.BrandValidateInterface;
import com.svysk.marketplace.pattern_extra.decorator.BrandValidateURLDecorator;
import com.svysk.marketplace.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;

@Service
public class BrandService {

    @Autowired
    BrandRepository repository;

    public BrandDTO save(BrandDTO newBrand) {
        BrandValidateInterface brandValidate = new BrandValidateURLDecorator(new BrandMapper());
        Brand brand;
        try {
            brand = brandValidate.toBrand(newBrand);
        } catch (MalformedURLException e) {
            return null;
        }
        repository.save(brand);
        return brandValidate.toBrandDTO(brand);
    }

    public boolean delete(Long id) {
        Brand brand = repository.getBrandById(id);
        repository.delete(brand);
        return true;
    }
}
