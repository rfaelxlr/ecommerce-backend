package com.ecommerce.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "carts")
public class Cart extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal total;

    private BigDecimal shipmentCost;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cartId" , orphanRemoval = true)
    private Set<CartItem> cartItems;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    public void addProduct(Integer quantity, Product product) {
        Optional<CartItem> existingItem = cartItems.stream()
                .filter(item -> item.getProduct().getId().equals(product.getId()))
                .findFirst();

        existingItem.ifPresent(item -> {
            item.setQuantity(item.getQuantity() + quantity);
            if (item.getQuantity() < 1) {
                cartItems.remove(item);
            }
        });

        if (quantity > 0 && existingItem.isEmpty()) {
            cartItems.add(new CartItem(this, product, quantity));
        }
    }


    public void refreshTotal() {
        this.total = cartItems.stream()
                .map(item -> item.getProduct().getPrice().multiply(new BigDecimal(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
