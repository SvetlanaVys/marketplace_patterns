package com.svysk.marketplace.pattern_extra.decorator;

import com.svysk.marketplace.dto.BrandDTO;
import com.svysk.marketplace.model.Brand;
import lombok.extern.slf4j.Slf4j;

import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class BrandValidateNameDecorator extends BrandDecorator {
    public BrandValidateNameDecorator(BrandValidateInterface component) {
        super(component);
    }

    @Override
    public Brand toBrand(BrandDTO brandDTO) throws Exception {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9-_\\.\\s]{0,255}$");
        Matcher matcher = pattern.matcher(brandDTO.getBrandName());
        if(matcher.matches()) {
            return component.toBrand(brandDTO);
        } else {
            log.error("Invalid brand name");
            throw new InvalidParameterException();
        }
    }
}
