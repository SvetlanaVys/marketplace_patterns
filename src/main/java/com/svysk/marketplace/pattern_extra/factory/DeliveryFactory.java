package com.svysk.marketplace.pattern_extra.factory;

public class DeliveryFactory {
    public static DeliveryService getDeliveryService(DeliveryType type) {
        switch (type) {
            case STANDARD:
                return new StandardDelivery();
            case EXPRESS:
                return new ExpressDelivery();
            case OVERNIGHT:
                return new OvernightDelivery();
            default:
                throw new IllegalArgumentException("Unknown delivery type: " + type);
        }
    }
}
