package com.svysk.marketplace.pattern_extra.decorator;

import com.svysk.marketplace.dto.BrandDTO;
import com.svysk.marketplace.model.Brand;

public abstract class BrandDecorator implements BrandValidateInterface {

    BrandValidateInterface component;

    public BrandDecorator(BrandValidateInterface component) {
        this.component = component;
    }

    @Override
    public BrandDTO toBrandDTO(Brand brand) {
        if(brand != null) {
            return this.component.toBrandDTO(brand);
        }

        return null;
    }

}
