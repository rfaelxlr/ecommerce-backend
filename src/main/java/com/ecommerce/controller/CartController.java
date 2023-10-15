package com.ecommerce.controller;

import com.ecommerce.controller.vo.CartAddProduct;
import com.ecommerce.controller.vo.CreateCartRequest;
import com.ecommerce.domain.Cart;
import com.ecommerce.service.CartService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/carts")
@AllArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping
    public ResponseEntity<?> createCart(@RequestBody @Valid CreateCartRequest request) {
        Cart cart = cartService.createCart(request);
        return ResponseEntity.created(URI.create("/carts/" + cart.getId()))
                .body(cart);
    }

    @PostMapping("/{cartId}")
    public ResponseEntity<?> addProduct(@PathVariable Long cartId, @RequestBody @Valid CartAddProduct request) {
        return ResponseEntity.ok(cartService.addProduct(cartId, request));
    }
}
