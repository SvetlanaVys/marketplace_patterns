package com.svysk.marketplace.pattern_extra.decorator;

import com.svysk.marketplace.dto.BrandDTO;
import com.svysk.marketplace.model.Brand;
import lombok.extern.slf4j.Slf4j;

import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
public class BrandValidateURLDecorator extends BrandDecorator {

    public BrandValidateURLDecorator(BrandValidateInterface component) {
        super(component);
    }

    @Override
    public Brand toBrand(BrandDTO brandDTO) throws Exception {
        try {
            new URL(brandDTO.getBrandURL());
            return component.toBrand(brandDTO);
        } catch (MalformedURLException e) {
            log.error("Invalid brand URL");
            throw new MalformedURLException();
        }
    }
}
