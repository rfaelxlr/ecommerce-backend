package com.ecommerce.domain;

import com.ecommerce.controller.vo.UpdateAdminRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Optional;

@Entity
@Table(name = "admins")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Admin extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean canManageProducts;
    private boolean canManageUsers;

    private boolean canManageOrders;

    private boolean canManageStores;

    private boolean superAdmin;

    private boolean canManageAdmins;

    public void update(UpdateAdminRequest request) {
        Optional.ofNullable(request.getName()).ifPresent(this::setName);
        Optional.ofNullable(request.getEmail()).ifPresent(this::setEmail);
        Optional.ofNullable(request.getPassword()).ifPresent(this::setPassword);
        Optional.ofNullable(request.getActive()).ifPresent(this::setActive);
        Optional.ofNullable(request.getCanManageProducts()).ifPresent(this::setCanManageProducts);
        Optional.ofNullable(request.getCanManageUsers()).ifPresent(this::setCanManageUsers);
        Optional.ofNullable(request.getCanManageOrders()).ifPresent(this::setCanManageOrders);
        Optional.ofNullable(request.getCanManageStores()).ifPresent(this::setCanManageStores);
        Optional.ofNullable(request.getSuperAdmin()).ifPresent(this::setSuperAdmin);
        Optional.ofNullable(request.getCanManageAdmins()).ifPresent(this::setCanManageAdmins);
    }
}
