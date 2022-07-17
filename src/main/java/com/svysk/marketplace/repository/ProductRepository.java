package com.svysk.marketplace.repository;

import com.svysk.marketplace.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query(value = "FROM Product")
    List<Product> getAll();

    @Query(value = "FROM Product WHERE category.id = :categoryId")
    List<Product> getProductByCategory(@Param("categoryId") Long categoryId);

    Product getProductById(@Param("id") Long id);

}
