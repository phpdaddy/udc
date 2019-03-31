package com.phpdaddy.udc.model.elastic;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "category", type = "category", shards = 1)
public class Category {
    private Long id;
    private String fullPath;
    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category(String name, Long id, String code, String fullPath) {

        this.name = name;
        this.id = id;
        this.code = code;
        this.fullPath = fullPath;
    }

    public Category() {

    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
