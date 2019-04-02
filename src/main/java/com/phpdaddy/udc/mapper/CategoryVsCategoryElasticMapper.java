package com.phpdaddy.udc.mapper;

import com.phpdaddy.udc.dto.CategoryDto;
import com.phpdaddy.udc.model.elastic.CategoryElastic;
import com.phpdaddy.udc.model.jpa.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CategoryVsCategoryElasticMapper {
    @Mappings({
            @Mapping(target = "parentId", source = "parent.id"),
            @Mapping(target = "fullPath", source = "destination", qualifiedByName = "fullPath"),
    })
    CategoryElastic categoryToCategoryElastic(Category destination);

    @Named("fullPath")
    default String getFullPath(Category c) {
        return (c.getParent() != null ? (getFullPath(c.getParent()) + " => ") : "") + c.getName();
    }
}
