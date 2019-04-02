package com.phpdaddy.udc.resource;

import com.phpdaddy.udc.dto.CategoryDto;
import com.phpdaddy.udc.dto.CategoryTreeDto;
import com.phpdaddy.udc.dto.CategoryUpdateDto;
import com.phpdaddy.udc.mapper.CategoryVsCategoryDtoMapper;
import com.phpdaddy.udc.mapper.CategoryVsCategoryTreeDtoMapper;
import com.phpdaddy.udc.mapper.CategoryVsCategoryUpdateMapper;
import com.phpdaddy.udc.repository.jpa.CategoryJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/categories")
public class CategoryResource {
    @Autowired
    CategoryJpaRepository categoryJpaRepository;

    @Autowired
    CategoryVsCategoryTreeDtoMapper categoryTreeDtoMapper;

    @Autowired
    CategoryVsCategoryDtoMapper categoryDtoMapper;

    @Autowired
    CategoryVsCategoryUpdateMapper categoryVsCategoryUpdateMapper;

    @GetMapping(value = "/tree")
    public List<CategoryTreeDto> tree() {

        return categoryJpaRepository.findByParentIsNullOrderByIdAsc().stream()
                .map(c -> categoryTreeDtoMapper.categoryToCategoryTreeDto(c)).collect(Collectors.toList());
    }


    @GetMapping(value = "")
    public List<CategoryDto> all() {

        return categoryJpaRepository.findAllByOrderByIdAsc().stream()
                .map(c -> categoryDtoMapper.categoryToCategoryDto(c)).collect(Collectors.toList());
    }

    @PostMapping(value = "")
    @Transactional
    public void save(@RequestBody List<CategoryUpdateDto> categoryUpdateDtos) {

        categoryJpaRepository.save(categoryUpdateDtos.stream()
                .map(c -> categoryVsCategoryUpdateMapper
                        .categoryUpdateDtoToCategory(c)).collect(Collectors.toList()));
    }
}
