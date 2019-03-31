package com.phpdaddy.udc.resource;

import com.phpdaddy.udc.model.elastic.Category;
import com.phpdaddy.udc.repository.elastic.CategoryRepository;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.DefaultEntityMapper;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.EntityMapper;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
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
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/rest/search")
public class SearchResource {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ElasticsearchOperations elasticsearchOperations;


    @GetMapping(value = "/keywords/{keywords}")
    public Category searchByKeywords(@PathVariable final List<String> keywords) {
        return searchByKeywords(keywords.toArray(new String[]{}));
    }


    @GetMapping(value = "/annotation/{annotation}")
    public Category searchByAnnotation(@PathVariable final String annotation) {
        String s = annotation.replaceAll("[,.]", " ")
                .trim().replaceAll(" +", " ").replaceAll("[ ]", ",");
        String[] keywords = s.split(",");
        return searchByKeywords(keywords);
    }

    private Category searchByKeywords(String[] keywords) {
        BoolQueryBuilder qb = QueryBuilders.boolQuery();

        Arrays.stream(keywords).forEach(keyword ->
        {
            qb.should(QueryBuilders.fuzzyQuery("fullPath", keyword)
                    .fuzziness(Fuzziness.AUTO));

        });

        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(qb).withSort(SortBuilders.fieldSort("_score").order(SortOrder.DESC)).build();
        List<Category> categories = elasticsearchOperations.query(searchQuery, new ResultsExtractor<List<Category>>() {

            @Override
            public List<Category> extract(SearchResponse searchResponse) {
                DefaultEntityMapper entityMapper = new DefaultEntityMapper();

                List<Category> categoryList = new ArrayList<>();
                for (SearchHit hit : searchResponse.getHits().getHits()) {
                    try {
                        Category category = entityMapper.mapToObject(hit.getSourceAsString(), Category.class);
                        categoryList.add(category);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Result: " + hit.getSourceAsString() + " " + hit.getScore());
                }
                return categoryList;
            }
        });
        Optional<Category> first = categories.stream().findFirst();

        return first.orElse(null);
        //return null;
    }

    @GetMapping(value = "/all")
    public List<Category> searchAll() {
        List<Category> categoryList = new ArrayList<>();
        Iterable<Category> categories = categoryRepository.findAll();
        categories.forEach(categoryList::add);
        return categoryList;
    }


}
