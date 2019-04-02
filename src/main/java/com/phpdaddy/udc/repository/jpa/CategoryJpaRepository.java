package com.phpdaddy.udc.repository.jpa;

import com.phpdaddy.udc.model.jpa.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CategoryJpaRepository extends JpaRepository<Category, Long> {

    List<Category> findByParentIsNullOrderByIdAsc();

    List<Category> findAllByOrderByIdAsc();
}
