package com.svysk.marketplace.pattern_extra.factory;

public class ExpressDelivery implements DeliveryService {
    @Override
    public void deliver(String orderDetails) {
        System.out.println("Processing express delivery for order: " + orderDetails);
    }
}
