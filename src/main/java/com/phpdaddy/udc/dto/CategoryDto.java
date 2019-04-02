package com.phpdaddy.udc.dto;

import com.phpdaddy.udc.model.jpa.Category;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Data
public class CategoryDto {
    private Long id;
    private Long parentId;
    private String name;
    private String code;
    private String keywords;
    private String fullPath;
    private Set<Long> children = new HashSet<>();
}
