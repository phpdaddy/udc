package com.phpdaddy.udc.repository.elastic;

import com.phpdaddy.udc.model.elastic.CategoryElastic;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CategoryRepository extends ElasticsearchRepository<CategoryElastic, Long> {
}
