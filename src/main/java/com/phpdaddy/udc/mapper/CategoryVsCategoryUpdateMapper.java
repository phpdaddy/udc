package com.phpdaddy.udc.mapper;

import com.phpdaddy.udc.dto.CategoryUpdateDto;
import com.phpdaddy.udc.model.jpa.Category;
import com.phpdaddy.udc.repository.jpa.CategoryJpaRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class CategoryVsCategoryUpdateMapper {
    @Autowired
    CategoryJpaRepository categoryJpaRepository;

    public Category categoryUpdateDtoToCategory(CategoryUpdateDto source) {
        Category one = categoryJpaRepository.findOne(source.getId());
        one.setKeywords(source.getKeywords());
        return one;
    }
}
