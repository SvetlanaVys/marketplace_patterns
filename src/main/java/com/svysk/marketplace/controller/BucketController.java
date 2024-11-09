package com.svysk.marketplace.controller;

import com.svysk.marketplace.dto.BucketProductDTO;
import com.svysk.marketplace.exception.UnknownProduct;
import com.svysk.marketplace.exception.UnknownPaymentMethodException;
import com.svysk.marketplace.pattern_extra.factory.DeliveryType;
import com.svysk.marketplace.pattern_extra.strategy.CreditCardPayment;
import com.svysk.marketplace.pattern_extra.strategy.PaymentMethod;
import com.svysk.marketplace.pattern_extra.strategy.PaypalPayment;
import com.svysk.marketplace.service.BucketProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/bucket", produces = MediaType.APPLICATION_JSON_VALUE)
public class BucketController {

    @Autowired
    BucketProductService service;

    @PostMapping("/add_product/{product_id}")
    BucketProductDTO addProductToBucket(@PathVariable("product_id") Long productId,
                                        @RequestParam PaymentMethod paymentMethod,
                                        @RequestParam DeliveryType deliveryType,
                                        @RequestParam(required = false) Long bucketId) throws UnknownProduct, UnknownPaymentMethodException {

        switch (paymentMethod) {
            case PAYPAL:
                service.setPaymentStrategy(new PaypalPayment());
                break;
            case CREDIT_CARD:
                service.setPaymentStrategy(new CreditCardPayment());
                break;
            default:
                throw new UnknownPaymentMethodException(String.format("PaymentMethod %s doesn't exist", paymentMethod));
        }
        return service.addProduct(productId, bucketId, deliveryType);
    }
}
