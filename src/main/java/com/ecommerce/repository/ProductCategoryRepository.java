package com.ecommerce.repository;

import com.ecommerce.domain.Category;
import com.ecommerce.domain.Product;
import com.ecommerce.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    ProductCategory findByProductAndCategory(Product product, Category category);
}