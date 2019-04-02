package com.phpdaddy.udc.mapper;

import com.phpdaddy.udc.dto.CategoryDto;
import com.phpdaddy.udc.dto.CategoryTreeDto;
import com.phpdaddy.udc.model.jpa.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryVsCategoryTreeDtoMapper {
    @Mappings({
            @Mapping(target = "parentId", source = "parent.id"),
    })
    CategoryTreeDto categoryToCategoryTreeDto(Category destination);
}
