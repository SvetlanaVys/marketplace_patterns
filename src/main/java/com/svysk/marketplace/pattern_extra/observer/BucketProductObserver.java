package com.svysk.marketplace.pattern_extra.observer;

public interface BucketProductObserver {
    void update(Long bucketId, Long productId);
}
