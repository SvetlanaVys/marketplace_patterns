package com.svysk.marketplace.service;

import com.svysk.marketplace.dto.BucketProductDTO;
import com.svysk.marketplace.exception.UnknownProduct;
import com.svysk.marketplace.pattern_extra.factory.DeliveryFactory;
import com.svysk.marketplace.pattern_extra.factory.DeliveryService;
import com.svysk.marketplace.pattern_extra.factory.DeliveryType;
import com.svysk.marketplace.mapper.BucketProductMapper;
import com.svysk.marketplace.model.Bucket;
import com.svysk.marketplace.model.BucketProduct;
import com.svysk.marketplace.model.Product;
import com.svysk.marketplace.pattern_extra.observer.BucketProductObserversHandler;
import com.svysk.marketplace.pattern_extra.strategy.PaymentStrategy;
import com.svysk.marketplace.repository.BucketProductRepository;
import com.svysk.marketplace.repository.BucketRepository;
import com.svysk.marketplace.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BucketProductService {

    @Autowired
    BucketRepository bucketRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    BucketProductRepository bucketProductRepository;

    @Autowired
    BucketProductMapper bucketProductMapper;

    @Autowired
    BucketProductObserversHandler bpHandler;

    PaymentStrategy paymentStrategy;

    DeliveryFactory deliveryFactory;

    @Transactional
    public BucketProductDTO addProduct(Long productId, Long bucketId, DeliveryType deliveryType) throws UnknownProduct {
        BucketProduct bucketProduct = bucketProductRepository.getBucketProductByBucketAndProduct(bucketId, productId);
        Bucket bucket = bucketRepository.getBrandById(bucketId);
        Product product = productRepository.getProductById(productId);
        BucketProductDTO bucketProductDTO;
        if(bucketProduct != null) {
            bucketProductDTO = bucketProductMapper.toBucketProductDTO(bucketProduct);
            bucketProductDTO.incrementProductCount();
        } else {
            if(product != null) {
                if(bucket == null) {
                    bucketId = bucketRepository.save(new Bucket()).getId();
                }
                bucketProductDTO = new BucketProductDTO.Builder()
                        .buildBucketId(bucketId)
                        .buildProductId(productId)
                        .build();
            } else {
                throw new UnknownProduct(String.format("Product with id=%s doesn't exist", productId));
            }
        }

        bpHandler.notifyObservers(bucketId, productId);
        BucketProductDTO savedBucketProductDTO = saveBucketProduct(bucketProductDTO);

        DeliveryService deliveryService = DeliveryFactory.getDeliveryService(deliveryType);
        deliveryService.deliver(savedBucketProductDTO.getId().toString());

        return savedBucketProductDTO;
    }

    public BucketProductDTO saveBucketProduct(BucketProductDTO bucketProductDTO) {
        BucketProduct bucketProduct = bucketProductMapper.toBucketProduct(bucketProductDTO);
        bucketProduct.calculateFinalBucketPrice();
        paymentStrategy.pay(bucketProduct.getBucket().getFinalPrice());
        bucketProductRepository.save(bucketProduct);
        return bucketProductMapper.toBucketProductDTO(bucketProduct);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}
