package com.phpdaddy.udc.load;

import com.phpdaddy.udc.extra.Helper;
import com.phpdaddy.udc.mapper.CategoryVsCategoryElasticMapper;
import com.phpdaddy.udc.model.elastic.CategoryElastic;
import com.phpdaddy.udc.repository.elastic.CategoryElasticRepository;
import com.phpdaddy.udc.repository.jpa.CategoryJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Loaders {

    @Autowired
    ElasticsearchOperations operations;

    @Autowired
    CategoryElasticRepository categoryElasticRepository;

    @Autowired
    CategoryJpaRepository categoryJpaRepository;

    @Autowired
    Helper helper;

    @Autowired
    CategoryVsCategoryElasticMapper categoryElasticDtoMapper;

    @PostConstruct
    @Transactional
    public void loadAll() {

        operations.putMapping(CategoryElastic.class);
        System.out.println("Loading Data");
        categoryElasticRepository.deleteAll();
        categoryElasticRepository.save(getData());
        System.out.printf("Loading Completed");

    }

    private List<CategoryElastic> getData() {
        List<com.phpdaddy.udc.model.jpa.Category> allByChildrenIsEmpty = categoryJpaRepository.findAll();

        return allByChildrenIsEmpty.stream()
                .filter(category -> (category.getChildren().isEmpty() && category.getName() != null))
                .map(c -> categoryElasticDtoMapper.categoryToCategoryElastic(c))
                .collect(Collectors.toList());
    }

}
