package com.ecommerce.service;

import com.ecommerce.domain.Category;
import com.ecommerce.domain.Product;
import com.ecommerce.domain.ProductCategory;
import com.ecommerce.exception.NotFoundException;
import com.ecommerce.repository.ProductCategoryRepository;
import com.ecommerce.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional()
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final CategoryService categoryService;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new NotFoundException("Product not Found!"));
    }

    public Product updateProduct(Long productId, Product productChanged) {
        Product product = getProduct(productId);
        product.update(productChanged);
        productRepository.save(product);
        return product;
    }


    public void saveProductCategory(Long categoryId, Product product) {
        if (categoryId != null) {
            Category category = categoryService.getCategory(categoryId);
            productCategoryRepository.save(new ProductCategory(category, product));
        }
    }

    public void deleteProductCategory(Long categoryId, Product product) {
        ProductCategory productCategory = productCategoryRepository.findByProductAndCategory(product, categoryService.getCategory(categoryId));
        if (productCategory != null) productCategoryRepository.delete(productCategory);
    }
}
