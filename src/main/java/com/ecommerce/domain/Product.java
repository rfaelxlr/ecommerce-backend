package com.ecommerce.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String ean;
    private BigDecimal price;



    public void update(Product request) {
        Optional.ofNullable(request.getName()).ifPresent(this::setName);
        Optional.ofNullable(request.getEan()).ifPresent(this::setEan);
        Optional.ofNullable(request.getPrice()).ifPresent(this::setPrice);
        setActive(request.isActive());
    }
}
