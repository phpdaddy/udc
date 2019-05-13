package com.misha.udc.resource;

import com.misha.udc.repository.jpa.CategoryJpaRepository;
import com.misha.udc.dto.CategoryDto;
import com.misha.udc.dto.CategoryTreeDto;
import com.misha.udc.dto.CategoryUpdateDto;
import com.misha.udc.mapper.CategoryVsCategoryDtoMapper;
import com.misha.udc.mapper.CategoryVsCategoryElasticMapper;
import com.misha.udc.mapper.CategoryVsCategoryTreeDtoMapper;
import com.misha.udc.mapper.CategoryVsCategoryUpdateMapper;
import com.misha.udc.model.elastic.CategoryElastic;
import com.misha.udc.model.jpa.Category;
import com.misha.udc.repository.elastic.CategoryElasticRepository;
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

    @Autowired
    CategoryVsCategoryElasticMapper categoryElasticDtoMapper;

    @Autowired
    private CategoryElasticRepository categoryElasticRepository;

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
        List<Category> collect = categoryUpdateDtos.stream()
                .map(c -> categoryVsCategoryUpdateMapper
                        .categoryUpdateDtoToCategory(c)).collect(Collectors.toList());

        categoryJpaRepository.save(collect);

        List<CategoryElastic> collect1 = collect.stream().map(c -> categoryElasticDtoMapper.categoryToCategoryElastic(c))
                .collect(Collectors.toList());

        categoryElasticRepository.save(collect1);
    }
}
