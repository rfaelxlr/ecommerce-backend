package com.ecommerce.domain;

import com.ecommerce.controller.vo.CreateUpdateCategoryRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    public void update(CreateUpdateCategoryRequest request) {
        Optional.ofNullable(request.getName()).ifPresent(this::setName);

    }
}