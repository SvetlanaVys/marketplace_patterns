package com.svysk.marketplace.exception;

public class UnknownPaymentMethodException extends Exception {
    public UnknownPaymentMethodException(String message) {
        super(message);
    }
}
