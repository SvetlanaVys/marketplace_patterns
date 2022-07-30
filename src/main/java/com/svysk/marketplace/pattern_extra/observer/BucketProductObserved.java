package com.svysk.marketplace.pattern_extra.observer;

import java.util.ArrayList;
import java.util.List;

public class BucketProductObserved {
   List<BucketProductObserver> observers = new ArrayList<>();

    public void subscribe(BucketProductObserver o) {
        observers.add(o);
    }

    public void unsubscribe(BucketProductObserver o) {
        observers.remove(o);
    }

    public void notify(Long bucketId, Long productId) {
        for (BucketProductObserver observer : observers) {
            observer.update(bucketId, productId);
        }
    }
}
