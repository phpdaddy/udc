package com.misha.udc.mapper;

import com.misha.udc.dto.CategoryDto;
import com.misha.udc.model.jpa.Category;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-04T01:58:19+0300",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 12 (Oracle Corporation)"
)
@Component
public class CategoryVsCategoryDtoMapperImpl extends CategoryVsCategoryDtoMapper {

    @Autowired
    private CategoryVsCategoryDtoMapperHelper categoryVsCategoryDtoMapperHelper;

    @Override
    public CategoryDto categoryToCategoryDto(Category destination) {
        if ( destination == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setFullPath( fullPath( destination ) );
        categoryDto.setChildren( children( destination ) );
        Long id = destinationParentId( destination );
        if ( id != null ) {
            categoryDto.setParentId( id );
        }
        categoryDto.setId( destination.getId() );
        categoryDto.setName( destination.getName() );
        categoryDto.setCode( destination.getCode() );
        categoryDto.setKeywords( categoryVsCategoryDtoMapperHelper.map( destination.getKeywords() ) );

        return categoryDto;
    }

    private Long destinationParentId(Category category) {
        if ( category == null ) {
            return null;
        }
        Category parent = category.getParent();
        if ( parent == null ) {
            return null;
        }
        Long id = parent.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
