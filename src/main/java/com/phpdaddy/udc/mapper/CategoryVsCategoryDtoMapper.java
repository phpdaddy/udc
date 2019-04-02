package com.phpdaddy.udc.mapper;

import com.phpdaddy.udc.dto.CategoryDto;
import com.phpdaddy.udc.model.jpa.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CategoryVsCategoryDtoMapper {
    @Mappings({
            @Mapping(target = "parentId", source = "parent.id"),
            @Mapping(target = "fullPath", source = "destination", qualifiedByName = "fullPath"),
            @Mapping(target = "children", source = "destination", qualifiedByName = "children"),
    })
    CategoryDto categoryToCategoryDto(Category destination);

    @Named("fullPath")
    default String fullPath(Category c) {
        return (c.getParent() != null ? (this.fullPath(c.getParent()) + " => ") : "") + c.getName();
    }

    @Named("children")
    default Set<Long> children(Category c) {
        return c.getChildren().stream().map(Category::getId).collect(Collectors.toSet());
    }
}
