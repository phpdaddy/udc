package com.phpdaddy.udc.repository.elastic;

import com.phpdaddy.udc.model.elastic.Category;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CategoryRepository extends ElasticsearchRepository<Category, Long> {
}
