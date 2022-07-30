package com.svysk.marketplace.pattern_extra.observer;

import org.springframework.stereotype.Component;

@Component
public class BucketProductObserversHandler {

    BucketProductObserved bpObserved;

    public BucketProductObserversHandler() {
        bpObserved = new BucketProductObserved();
        bpObserved.subscribe(new LogBucketProductObserver());
        bpObserved.subscribe(new ConsoleBucketProductObserver());
    }

    public void subscribeObserver(BucketProductObserver o) {
        bpObserved.subscribe(o);
    }

    public void unsubscribeObserver(BucketProductObserver o) {
        bpObserved.unsubscribe(o);
    }

    public void notifyObservers(Long bucketId, Long productId) {
        bpObserved.notify(bucketId, productId);
    }
}
