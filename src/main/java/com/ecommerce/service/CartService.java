package com.ecommerce.service;

import com.ecommerce.controller.vo.CartAddProduct;
import com.ecommerce.domain.Cart;
import com.ecommerce.domain.Product;
import com.ecommerce.exception.NotFoundException;
import com.ecommerce.factory.CartFactory;
import com.ecommerce.repository.CartItemRepository;
import com.ecommerce.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartFactory cartFactory;
    private final CartItemRepository cartItemRepository;
    private final ProductService productService;

    public Cart findById(Long cartId) {
        return cartRepository.findById(cartId).orElseThrow(() -> new NotFoundException("Cart not Found!"));
    }

    public Cart createCart() {
        return cartRepository.save(cartFactory.createEmptyCart());
    }

    public Cart addProduct(Long cartId, CartAddProduct request) {
        Cart cart = findById(cartId);
        Product product = productService.getProduct(request.getProductId());
        cart.addProduct(request.getQuantity(), product);
        cart.refreshTotal();
        cartRepository.save(cart);
        return cart;
    }
}
