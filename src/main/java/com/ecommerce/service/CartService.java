package com.ecommerce.service;

import com.ecommerce.controller.vo.CartAddProduct;
import com.ecommerce.controller.vo.CreateCartRequest;
import com.ecommerce.domain.Cart;
import com.ecommerce.domain.Product;
import com.ecommerce.domain.Store;
import com.ecommerce.exception.NotFoundException;
import com.ecommerce.factory.CartFactory;
import com.ecommerce.repository.CartItemRepository;
import com.ecommerce.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartFactory cartFactory;
    private final CartItemRepository cartItemRepository;
    private final ProductService productService;
    private final StoreService storeService;

    public Cart findById(Long cartId) {
        return cartRepository.findById(cartId).orElseThrow(() -> new NotFoundException("Cart not Found!"));
    }

    public Cart createCart(CreateCartRequest request) {
        Store store = storeService.getActiveStore(request.getStoreId());
        return cartRepository.save(cartFactory.createEmptyCart(store));
    }

    public Cart addProduct(Long cartId, CartAddProduct request) {
        Cart cart = findById(cartId);
        Product product = productService.getProduct(request.getProductId());
        cart.addProduct(request.getQuantity(), product);
        cart.refreshTotal();
        cartRepository.save(cart);
        return cart;
    }

    public Cart setShipmentCost(Double km, Long cartId) {
        Cart cart = findById(cartId);
        BigDecimal shipmentCost = storeService.getShipmentCost(km, cart.getStore());
        cart.setShipmentCost(shipmentCost);
        return cartRepository.save(cart);
    }

}
