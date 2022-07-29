package com.svysk.marketplace.repository;

import com.svysk.marketplace.model.BucketProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BucketProductRepository extends JpaRepository<BucketProduct, String> {

    @Query(value = "FROM BucketProduct WHERE bucket.id = :bucket_id AND product.id = :product_id")
    BucketProduct getBucketProductByBucketAndProduct(@Param("bucket_id") Long bucketId,
                                                     @Param("product_id") Long productId);
}
