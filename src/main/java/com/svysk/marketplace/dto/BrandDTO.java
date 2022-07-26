package com.svysk.marketplace.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

@Getter
public class BrandDTO {

    @JsonIgnore
    Long id;

    String brandName;

    String brandURL;

    public static class Builder {
        private BrandDTO brandDTO;

        public Builder() {
            brandDTO = new BrandDTO();
        }

        public Builder buildId(Long id) {
            brandDTO.id = id;
            return this;
        }

        public Builder buildBrandName(String brandName) {
            brandDTO.brandName = brandName;
            return this;
        }

        public Builder buildBrandURL(String brandURL) {
            brandDTO.brandURL = brandURL;
            return this;
        }

        public BrandDTO build() {
            return brandDTO;
        }
    }
}
