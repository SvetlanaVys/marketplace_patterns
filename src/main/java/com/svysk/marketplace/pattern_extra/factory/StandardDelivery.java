package com.svysk.marketplace.pattern_extra.factory;

public class StandardDelivery implements DeliveryService {
    @Override
    public void deliver(String orderDetails) {
        System.out.println("Processing standard delivery for order: " + orderDetails);
    }
}

