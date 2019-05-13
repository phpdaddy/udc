package com.misha.udc.repository.elastic;

import com.misha.udc.model.elastic.CategoryElastic;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CategoryElasticRepository extends ElasticsearchRepository<CategoryElastic, Long> {
}
