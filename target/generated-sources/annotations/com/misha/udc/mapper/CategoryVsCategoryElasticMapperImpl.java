package com.misha.udc.mapper;

import com.misha.udc.model.elastic.CategoryElastic;
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
public class CategoryVsCategoryElasticMapperImpl extends CategoryVsCategoryElasticMapper {

    @Autowired
    private CategoryVsCategoryElasticMapperHelper categoryVsCategoryElasticMapperHelper;

    @Override
    public CategoryElastic categoryToCategoryElastic(Category destination) {
        if ( destination == null ) {
            return null;
        }

        CategoryElastic categoryElastic = new CategoryElastic();

        categoryElastic.setFullPath( fullPath( destination ) );
        Long id = destinationParentId( destination );
        if ( id != null ) {
            categoryElastic.setParentId( id );
        }
        categoryElastic.setId( destination.getId() );
        categoryElastic.setName( destination.getName() );
        categoryElastic.setCode( destination.getCode() );
        categoryElastic.setKeywords( categoryVsCategoryElasticMapperHelper.map( destination.getKeywords() ) );

        return categoryElastic;
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
