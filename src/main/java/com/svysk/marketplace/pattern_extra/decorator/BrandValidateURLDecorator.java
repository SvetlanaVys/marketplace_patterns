package com.svysk.marketplace.pattern_extra.decorator;

import com.svysk.marketplace.dto.BrandDTO;
import com.svysk.marketplace.model.Brand;
import lombok.extern.slf4j.Slf4j;

import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
public class BrandValidateURLDecorator implements BrandValidateInterface {

    BrandValidateInterface component;

    public BrandValidateURLDecorator(BrandValidateInterface component) {
        this.component = component;
    }

    @Override
    public BrandDTO toBrandDTO(Brand brand) {
        if(brand != null) {
            return this.component.toBrandDTO(brand);
        }

        return null;
    }

    @Override
    public Brand toBrand(BrandDTO brandDTO) throws MalformedURLException {
        try {
            new URL(brandDTO.getBrandURL());
        } catch (MalformedURLException e) {
            log.error("Invalid brand URL");
            throw new MalformedURLException();
        }

        return component.toBrand(brandDTO);
    }
}
