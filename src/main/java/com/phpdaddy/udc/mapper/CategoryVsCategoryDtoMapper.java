package com.phpdaddy.udc.mapper;

import com.phpdaddy.udc.dto.CategoryDto;
import com.phpdaddy.udc.extra.Helper;
import com.phpdaddy.udc.model.jpa.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class CategoryVsCategoryDtoMapper {
    @Autowired
    Helper helper;

    @Mappings({
            @Mapping(target = "parentId", source = "parent.id"),
            @Mapping(target = "fullPath", source = "destination", qualifiedByName = "fullPath"),
            @Mapping(target = "children", source = "destination", qualifiedByName = "children"),
    })
    public abstract CategoryDto categoryToCategoryDto(Category destination);

    @Named("fullPath")
    public String fullPath(Category c) {
        return helper.getFullPath(c);
    }

    @Named("children")
    public Set<Long> children(Category c) {
        return c.getChildren().stream().map(Category::getId).collect(Collectors.toSet());
    }
}
