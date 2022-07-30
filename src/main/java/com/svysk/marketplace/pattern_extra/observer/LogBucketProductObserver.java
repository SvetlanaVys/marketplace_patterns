package com.svysk.marketplace.pattern_extra.observer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogBucketProductObserver implements BucketProductObserver {
    @Override
    public void update(Long bucketId, Long productId) {
        log.info(String.format("Product with id=%s was added to the bucket with id=%s", productId, bucketId));
    }
}
