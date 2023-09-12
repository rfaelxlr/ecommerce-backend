package com.ecommerce.controller;

import com.ecommerce.controller.vo.CategoryResponse;
import com.ecommerce.controller.vo.CreateUpdateCategoryRequest;
import com.ecommerce.domain.Category;
import com.ecommerce.service.CategoryService;
import com.ecommerce.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok(mapperUtil.convertList(categoryService.getCategories(), CategoryResponse.class));
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<?> getCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(mapperUtil.convert(categoryService.getCategory(categoryId), CategoryResponse.class));
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody @Valid CreateUpdateCategoryRequest request) {
        Category category = categoryService.createCategory(mapperUtil.convert(request, Category.class));
        return ResponseEntity.created(URI.create("/categories/" + category.getId()))
                .body(mapperUtil.convert(category, CategoryResponse.class));
    }

    @PatchMapping("/{categoryId}")
    public ResponseEntity<?> updateCategory(@PathVariable Long categoryId, @RequestBody CreateUpdateCategoryRequest request) {
        return ResponseEntity.ok(mapperUtil.convert(categoryService.updateCategory(categoryId, request), CategoryResponse.class));
    }
}
