package com.phpdaddy.udc.repository.jpa;

import com.phpdaddy.udc.model.jpa.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryJpaRepository extends JpaRepository<Category, Long> {

}
