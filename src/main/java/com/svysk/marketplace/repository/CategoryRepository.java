package com.svysk.marketplace.repository;

import com.svysk.marketplace.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, String> {

    @Query(value = "FROM Category")
    List<Category> getAll();

    Category getCategoryById(@Param("id") Long id);

    List<Category> getCategoriesByCategoryName(@Param("name") String name);
}
