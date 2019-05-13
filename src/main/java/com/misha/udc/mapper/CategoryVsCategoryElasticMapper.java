package com.misha.udc.mapper;

import com.misha.udc.extra.Helper;
import com.misha.udc.model.elastic.CategoryElastic;
import com.misha.udc.model.jpa.Category;
import com.misha.udc.model.jpa.Keyword;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",uses= CategoryVsCategoryElasticMapper.CategoryVsCategoryElasticMapperHelper.class)
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


    @Service
    public static class CategoryVsCategoryElasticMapperHelper {
        String map(Set<Keyword> set) {
            return set.stream().map(Keyword::getName).collect(Collectors.joining(","));
        }
    }
}
