package com.misha.udc.resource;

import com.misha.udc.extra.Helper;
import com.misha.udc.model.elastic.CategoryElastic;
import com.misha.udc.repository.elastic.CategoryElasticRepository;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.DefaultEntityMapper;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/categories/search")
public class CategoryElasticResource {

    @Autowired
    CategoryElasticRepository categoryRepository;

    @Autowired
    ElasticsearchOperations elasticsearchOperations;

    @Autowired
    Helper keywordsExtractor;


    @GetMapping(value = "/keywords/{keywords}")
    public CategoryElastic searchByKeywords(@PathVariable final List<String> keywords) {
        return searchByKeywords(keywords.toArray(new String[]{}));
    }


    @GetMapping(value = "/annotation/{annotation}")
    public CategoryElastic searchByAnnotation(@PathVariable final String annotation) {
        String s = keywordsExtractor.getKeyWordsFromText(annotation);
        String[] keywords = s.split(",");
        return searchByKeywords(keywords);
    }


    private CategoryElastic searchByKeywords(String[] keywords) {
        BoolQueryBuilder qb = QueryBuilders.boolQuery();

        Arrays.stream(keywords).forEach(keyword ->
        {
            qb.should(QueryBuilders.fuzzyQuery("keywords", keyword)
                    .fuzziness(Fuzziness.AUTO));

        });

        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(qb).withSort(SortBuilders.fieldSort("_score").order(SortOrder.DESC)).build();
        List<CategoryElastic> categories = elasticsearchOperations.query(searchQuery, searchResponse -> {
            DefaultEntityMapper entityMapper = new DefaultEntityMapper();

            List<CategoryElastic> categoryList = new ArrayList<>();
            for (SearchHit hit : searchResponse.getHits().getHits()) {
                try {
                    CategoryElastic category = entityMapper.mapToObject(hit.getSourceAsString(), CategoryElastic.class);
                    categoryList.add(category);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Result: " + hit.getSourceAsString() + " " + hit.getScore());
            }
            return categoryList;
        });
        Optional<CategoryElastic> first = categories.stream().findFirst();

        return first.orElse(null);
    }

    @GetMapping(value = "/all")
    public List<CategoryElastic> searchAll() {
        List<CategoryElastic> categoryList = new ArrayList<>();
        Iterable<CategoryElastic> categories = categoryRepository.findAll();
        categories.forEach(categoryList::add);
        return categoryList;
    }


}
