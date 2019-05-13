package com.misha.udc.mapper;

import com.misha.udc.dto.CategoryTreeDto;
import com.misha.udc.model.jpa.Category;
import com.misha.udc.model.jpa.Keyword;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",uses = CategoryVsCategoryTreeDtoMapper.CategoryVsCategoryTreeDtoMapperHelper.class)
public interface CategoryVsCategoryTreeDtoMapper {
    @Mappings({
            @Mapping(target = "parentId", source = "parent.id"),
    })
    CategoryTreeDto categoryToCategoryTreeDto(Category destination);

    @Service
    public static class CategoryVsCategoryTreeDtoMapperHelper {
        String map(Set<Keyword> set) {
            return set.stream().map(Keyword::getName).collect(Collectors.joining(","));
        }
    }
}
