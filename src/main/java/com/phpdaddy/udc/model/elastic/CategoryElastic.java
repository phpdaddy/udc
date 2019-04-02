package com.phpdaddy.udc.model.elastic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "category", type = "category", shards = 1)
@Getter
@Setter
@NoArgsConstructor
public class CategoryElastic {
    private Long id;
    private Long parentId;
    private String fullPath;
    private String name;
    private String code;
    private String keywords;

    public CategoryElastic(String name, Long id, String code, String fullPath, String keywords) {

        this.name = name;
        this.id = id;
        this.code = code;
        this.fullPath = fullPath;
        this.keywords = keywords;
    }
}
