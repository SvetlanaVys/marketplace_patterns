package com.svysk.marketplace.pattern_extra.factory;

public class OvernightDelivery implements DeliveryService {
    @Override
    public void deliver(String orderDetails) {
        System.out.println("Processing overnight delivery for order: " + orderDetails);
    }
}
