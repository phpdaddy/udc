package com.phpdaddy.udc.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CategoryTreeDto {
    private Long id;
    private Long parentId;
    private Set<CategoryTreeDto> children = new HashSet<>();
    private String name;
    private String code;
    private String keywords;
}
