package com.misha.udc.repository.jpa;

import com.misha.udc.model.jpa.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CategoryJpaRepository extends JpaRepository<Category, Long> {

    List<Category> findByParentIsNullOrderByIdAsc();

    List<Category> findAllByOrderByIdAsc();
}
