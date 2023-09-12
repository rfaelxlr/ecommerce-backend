package com.ecommerce.service;

import com.ecommerce.controller.vo.CreateUpdateCategoryRequest;
import com.ecommerce.controller.vo.UpdateProductRequest;
import com.ecommerce.domain.Category;
import com.ecommerce.domain.Product;
import com.ecommerce.repository.CategoryRepository;
import com.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not Found!"));
    }

    public Category updateCategory(Long categoryId, CreateUpdateCategoryRequest request) {
        Category category = getCategory(categoryId);
        category.update(request);
        categoryRepository.save(category);
        return category;
    }
}
