package com.ecommerce.service;

import com.ecommerce.controller.vo.UpdateProductRequest;
import com.ecommerce.domain.Product;
import com.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not Found!"));
    }

    public Product updateProduct(Long productId, UpdateProductRequest request) {
        Product product = getProduct(productId);
        product.update(request);
        productRepository.save(product);
        return product;
    }
}
