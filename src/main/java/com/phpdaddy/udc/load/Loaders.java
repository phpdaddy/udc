package com.phpdaddy.udc.load;

import com.phpdaddy.udc.model.elastic.Category;
import com.phpdaddy.udc.repository.elastic.CategoryRepository;
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
    CategoryRepository categoryRepository;

    @Autowired
    CategoryJpaRepository categoryJpaRepository;

    @PostConstruct
    @Transactional
    public void loadAll() {

        operations.putMapping(Category.class);
        System.out.println("Loading Data");
        categoryRepository.deleteAll();
        categoryRepository.save(getData());
        System.out.printf("Loading Completed");

    }

    private List<Category> getData() {
        List<com.phpdaddy.udc.model.jpa.Category> allByChildrenIsEmpty = categoryJpaRepository.findAll();

        return allByChildrenIsEmpty.stream().filter(category -> category.getChildren().isEmpty()).map(c ->
                new Category(c.getName(), c.getId(), c.getCode(), getFullPath(c))).collect(Collectors.toList());
    }

    private String getFullPath(com.phpdaddy.udc.model.jpa.Category c) {
        return (c.getParent() != null ? (getFullPath(c.getParent()) + " => ") : "") + c.getName();
    }
}
