package com.svysk.marketplace.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "bucket_product")
public class BucketProduct implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bucket_id")
    Bucket bucket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    Product product;

    @Column(name = "product_count", columnDefinition = "integer default 1")
    Integer productCount = 1;

    public void calculateFinalBucketPrice() {
        bucket.setFinalPrice(bucket.getFinalPrice() + product.getPrice());
    }
}
