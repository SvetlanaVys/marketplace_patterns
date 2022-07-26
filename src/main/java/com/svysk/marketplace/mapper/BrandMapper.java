package com.svysk.marketplace.mapper;

import com.svysk.marketplace.dto.BrandDTO;
import com.svysk.marketplace.model.Brand;
import com.svysk.marketplace.pattern_extra.decorator.BrandValidateInterface;

public class BrandMapper implements BrandValidateInterface {

    public BrandDTO toBrandDTO(Brand brand) {
        return new BrandDTO.Builder()
                .buildId(brand.getId())
                .buildBrandName(brand.getBrandName())
                .buildBrandURL(brand.getBrandURL())
                .build();
    }

    public Brand toBrand(BrandDTO brandDTO) {
        Brand brand = new Brand();
        brand.setId(brandDTO.getId());
        brand.setBrandName(brandDTO.getBrandName());
        brand.setBrandURL(brandDTO.getBrandURL());
        return brand;
    }

}
