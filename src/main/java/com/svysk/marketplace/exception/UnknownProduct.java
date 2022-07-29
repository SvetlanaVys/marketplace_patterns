package com.svysk.marketplace.exception;

public class UnknownProduct extends Throwable {
    public UnknownProduct(String errorMessage) {
        super(errorMessage);
    }
}
