package com.svysk.marketplace.mapper;

import com.svysk.marketplace.dto.BrandDTO;
import com.svysk.marketplace.model.Brand;

public class BrandMapper {

    public static BrandDTO toBrandDTO(Brand brand) {
        return new BrandDTO.Builder()
                .buildId(brand.getId())
                .buildBrandName(brand.getBrandName())
                .buildBrandURL(brand.getBrandURL())
                .build();
    }

    public static Brand toBrand(BrandDTO brandDTO) {
        Brand brand = new Brand();
        brand.setId(brandDTO.getId());
        brand.setBrandName(brandDTO.getBrandName());
        brand.setBrandURL(brandDTO.getBrandURL());
        return brand;
    }

}
