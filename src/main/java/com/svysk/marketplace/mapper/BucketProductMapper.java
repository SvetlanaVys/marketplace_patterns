package com.svysk.marketplace.mapper;

import com.svysk.marketplace.dto.BucketProductDTO;
import com.svysk.marketplace.model.BucketProduct;
import com.svysk.marketplace.repository.BucketRepository;
import com.svysk.marketplace.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BucketProductMapper {

    @Autowired
    BucketRepository bucketRepository;

    @Autowired
    ProductRepository productRepository;

    public BucketProductDTO toBucketProductDTO(BucketProduct bucketProduct) {
        return new BucketProductDTO.Builder()
                .buildId(bucketProduct.getId())
                .buildBucketId(bucketProduct.getBucket().getId())
                .buildProductId(bucketProduct.getProduct().getId())
                .buildProductCount(bucketProduct.getProductCount())
                .build();
    }

    public BucketProduct toBucketProduct(BucketProductDTO bucketProductDTO) {
        BucketProduct bucketProduct = new BucketProduct();
        bucketProduct.setId(bucketProductDTO.getId());
        bucketProduct.setBucket(bucketRepository.getBrandById(bucketProductDTO.getBucketId()));
        bucketProduct.setProduct(productRepository.getProductById(bucketProductDTO.getProductId()));
        bucketProduct.setProductCount(bucketProductDTO.getProductCount());
        return bucketProduct;
    }
}
