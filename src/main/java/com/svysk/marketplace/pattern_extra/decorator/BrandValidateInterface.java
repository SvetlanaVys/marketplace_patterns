package com.svysk.marketplace.pattern_extra.decorator;

import com.svysk.marketplace.dto.BrandDTO;
import com.svysk.marketplace.model.Brand;

public interface BrandValidateInterface {

    BrandDTO toBrandDTO(Brand brand);

    Brand toBrand(BrandDTO brandDTO) throws Exception;
}
