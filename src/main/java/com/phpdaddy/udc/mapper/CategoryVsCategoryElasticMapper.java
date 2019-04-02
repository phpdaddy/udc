package com.phpdaddy.udc.mapper;

import com.phpdaddy.udc.dto.CategoryDto;
import com.phpdaddy.udc.extra.Helper;
import com.phpdaddy.udc.model.elastic.CategoryElastic;
import com.phpdaddy.udc.model.jpa.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class CategoryVsCategoryElasticMapper {
    @Autowired
    private Helper helper;

    @Mappings({
            @Mapping(target = "parentId", source = "parent.id"),
            @Mapping(target = "fullPath", source = "destination", qualifiedByName = "fullPath"),
    })
    public abstract CategoryElastic categoryToCategoryElastic(Category destination);

    @Named("fullPath")
    public String fullPath(Category c) {
        return helper.getFullPath(c);
    }
}
