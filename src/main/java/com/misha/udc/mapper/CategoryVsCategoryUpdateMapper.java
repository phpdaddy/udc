package com.misha.udc.mapper;

import com.misha.udc.repository.jpa.CategoryJpaRepository;
import com.misha.udc.dto.CategoryUpdateDto;
import com.misha.udc.model.jpa.Category;
import com.misha.udc.model.jpa.Keyword;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class CategoryVsCategoryUpdateMapper {
    @Autowired
    CategoryJpaRepository categoryJpaRepository;

    public Category categoryUpdateDtoToCategory(CategoryUpdateDto source) {
        Category one = categoryJpaRepository.findOne(source.getId());
        String[] split = source.getKeywords().split(",");
        one.setKeywords(Arrays.stream(split).map(s -> {
            Keyword keyword = new Keyword();
            keyword.setName(s);
            return keyword;
        }).collect(Collectors.toSet()));
        return one;
    }
}
