package com.ecommerce.controller;

import com.ecommerce.controller.vo.ProductRequest;
import com.ecommerce.controller.vo.ProductResponse;
import com.ecommerce.controller.vo.UpdateProductRequest;
import com.ecommerce.domain.Product;
import com.ecommerce.service.ProductService;
import com.ecommerce.util.MapperUtil;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<?> getProducts() {
        return ResponseEntity.ok(mapperUtil.convertList(productService.getProducts(), ProductResponse.class));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(mapperUtil.convert(productService.getProduct(productId), ProductResponse.class));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProductResponse> createProduct(@RequestBody @Valid ProductRequest request) {
        Product product = productService.createProduct(mapperUtil.convert(request.getProduct(), Product.class));
        productService.saveProductCategory(request.getCategoryId(), product);
        return ResponseEntity.created(URI.create("/products/" + product.getId()))
                .body(mapperUtil.convert(product, ProductResponse.class));
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable Long productId, @RequestBody UpdateProductRequest request) {
        Product product = mapperUtil.convert(request.getProduct(), Product.class);
        return ResponseEntity.ok(mapperUtil.convert(productService.updateProduct(productId, product), ProductResponse.class));
    }

    @PostMapping("/{productId}/categories/{categoryId}")
    public ResponseEntity<?> saveProductCategory(@PathVariable Long categoryId, @PathVariable Long productId) {
        Product product = productService.getProduct(productId);
        productService.saveProductCategory(categoryId, product);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{productId}/categories/{categoryId}")
    public ResponseEntity<?> deleteProductCategory(@PathVariable Long categoryId, @PathVariable Long productId) {
        Product product = productService.getProduct(productId);
        productService.deleteProductCategory(categoryId, product);
        return ResponseEntity.noContent().build();
    }

}
