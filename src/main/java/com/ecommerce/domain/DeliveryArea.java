package com.ecommerce.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;

@Entity
@Table(name = "delivery_areas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryArea extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double kilometersDistance;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    public void update(DeliveryArea deliveryArea) {
        Optional.ofNullable(deliveryArea.getKilometersDistance()).ifPresent(this::setKilometersDistance);
        Optional.ofNullable(deliveryArea.getPrice()).ifPresent(this::setPrice);
        this.setActive(deliveryArea.isActive());
    }
}
