package com.svysk.marketplace.model;

import com.svysk.marketplace.prototype.Prototype;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "category")
public class Category implements Prototype {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "category_name", nullable = false)
    String categoryName;

    @Override
    public Object copy() {
        Category categoryCopy = new Category();
        categoryCopy.setId(id);
        categoryCopy.setCategoryName(categoryName);

        return categoryCopy;
    }
}
