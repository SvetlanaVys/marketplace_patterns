package com.svysk.marketplace.repository;

import com.svysk.marketplace.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BrandRepository extends JpaRepository<Brand, String> {

    Brand getBrandById(@Param("id") Long brandId);
}
