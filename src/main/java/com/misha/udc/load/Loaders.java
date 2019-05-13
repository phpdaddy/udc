package com.misha.udc.load;

import com.misha.udc.extra.Helper;
import com.misha.udc.mapper.CategoryVsCategoryElasticMapper;
import com.misha.udc.model.elastic.CategoryElastic;
import com.misha.udc.model.jpa.Category;
import com.misha.udc.repository.jpa.CategoryJpaRepository;
import com.misha.udc.repository.elastic.CategoryElasticRepository;
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
        List<Category> list = categoryJpaRepository.findAll();

        return list.stream()
                .map(c -> categoryElasticDtoMapper.categoryToCategoryElastic(c))
                .collect(Collectors.toList());
    }

}
