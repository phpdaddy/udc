package com.misha.udc.mapper;

import com.misha.udc.dto.CategoryTreeDto;
import com.misha.udc.model.jpa.Category;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-04T01:58:19+0300",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 12 (Oracle Corporation)"
)
@Component
public class CategoryVsCategoryTreeDtoMapperImpl implements CategoryVsCategoryTreeDtoMapper {

    @Autowired
    private CategoryVsCategoryTreeDtoMapperHelper categoryVsCategoryTreeDtoMapperHelper;

    @Override
    public CategoryTreeDto categoryToCategoryTreeDto(Category destination) {
        if ( destination == null ) {
            return null;
        }

        CategoryTreeDto categoryTreeDto = new CategoryTreeDto();

        Long id = destinationParentId( destination );
        if ( id != null ) {
            categoryTreeDto.setParentId( id );
        }
        categoryTreeDto.setId( destination.getId() );
        categoryTreeDto.setChildren( categorySetToCategoryTreeDtoSet( destination.getChildren() ) );
        categoryTreeDto.setName( destination.getName() );
        categoryTreeDto.setCode( destination.getCode() );
        categoryTreeDto.setKeywords( categoryVsCategoryTreeDtoMapperHelper.map( destination.getKeywords() ) );

        return categoryTreeDto;
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

    protected Set<CategoryTreeDto> categorySetToCategoryTreeDtoSet(Set<Category> set) {
        if ( set == null ) {
            return null;
        }

        Set<CategoryTreeDto> set1 = new HashSet<CategoryTreeDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Category category : set ) {
            set1.add( categoryToCategoryTreeDto( category ) );
        }

        return set1;
    }
}
