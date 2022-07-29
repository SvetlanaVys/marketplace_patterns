package com.svysk.marketplace.repository;

import com.svysk.marketplace.model.Bucket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BucketRepository extends JpaRepository<Bucket, String> {

    Bucket getBrandById(@Param("id") Long bucketId);
}
