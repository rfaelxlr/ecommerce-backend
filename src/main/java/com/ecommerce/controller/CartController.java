package com.ecommerce.controller;

import com.ecommerce.controller.vo.CartAddProduct;
import com.ecommerce.controller.vo.CreateCartRequest;
import com.ecommerce.domain.Cart;
import com.ecommerce.service.CartService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/carts")
@AllArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping
    public ResponseEntity<?> createCart(@RequestBody @Valid CreateCartRequest request, @RequestHeader("customer_id") Long customerId) {
        Cart cart = cartService.createCart(request, customerId);
        return ResponseEntity.created(URI.create("/carts/" + cart.getId()))
                .body(cart);
    }

    @PostMapping("/{cartId}")
    public ResponseEntity<?> addProduct(@PathVariable Long cartId, @RequestBody @Valid CartAddProduct request) {
        return ResponseEntity.ok(cartService.addProduct(cartId, request));
    }

    @PostMapping("/{cartId}/km/{km}")
    public ResponseEntity<?> setShipmentCost(@PathVariable Long cartId, @PathVariable Double km) {
        return ResponseEntity.ok(cartService.setShipmentCost(km, cartId));
    }

    @PatchMapping("/{cartId}/addresses/{addressId}")
    public ResponseEntity<?> setAddressToCart( @PathVariable Long cartId, @PathVariable Long addressId) {
        return ResponseEntity.ok(cartService.setAddressToCart(cartId, addressId));
    }
}
