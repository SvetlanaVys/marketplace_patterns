package com.svysk.marketplace.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class BucketProductDTO {

    @JsonIgnore
    Long id;

    Long bucketId;

    Long productId;

    Integer productCount = 1;

    public static class Builder {
        BucketProductDTO bucketProductDTO;

        public Builder() {
            bucketProductDTO = new BucketProductDTO();
        }

        public Builder buildId(Long id) {
            bucketProductDTO.id = id;
            return this;
        }

        public Builder buildBucketId(Long bucketId) {
            bucketProductDTO.bucketId = bucketId;
            return this;
        }

        public Builder buildProductId(Long productId) {
            bucketProductDTO.productId = productId;
            return this;
        }

        public Builder buildProductCount(Integer productCount) {
            bucketProductDTO.productCount = productCount;
            return this;
        }

        public BucketProductDTO build() {
            return bucketProductDTO;
        }
    }

    public void incrementProductCount() {
        productCount++;
    }
}
