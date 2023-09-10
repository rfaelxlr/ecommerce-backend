package com.ecommerce.controller;

import com.ecommerce.controller.vo.CreateProductRequest;
import com.ecommerce.controller.vo.ProductResponse;
import com.ecommerce.controller.vo.UpdateProductRequest;
import com.ecommerce.domain.Product;
import com.ecommerce.service.ProductService;
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
    public ResponseEntity<ProductResponse> createProduct(@RequestBody @Valid CreateProductRequest request) {
        Product product = productService.createProduct(mapperUtil.convert(request, Product.class));
        return ResponseEntity.created(URI.create("/products/" + product.getId()))
                .body(mapperUtil.convert(product, ProductResponse.class));
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable Long productId, @RequestBody UpdateProductRequest request) {
        return ResponseEntity.ok(mapperUtil.convert(productService.updateProduct(productId, request), ProductResponse.class));
    }
}
