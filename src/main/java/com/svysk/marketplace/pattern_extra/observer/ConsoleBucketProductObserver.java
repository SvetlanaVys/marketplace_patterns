package com.svysk.marketplace.pattern_extra.observer;

public class ConsoleBucketProductObserver implements BucketProductObserver {
    @Override
    public void update(Long bucketId, Long productId) {
        System.out.println(String.format("Product with id=%s was added to the bucket with id=%s", productId, bucketId));
    }
}
