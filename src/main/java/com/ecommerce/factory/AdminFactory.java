package com.ecommerce.factory;

import com.ecommerce.controller.vo.CreateAdminRequest;
import com.ecommerce.domain.Admin;
import org.springframework.stereotype.Component;

@Component
public class AdminFactory {

    public Admin createAdmin(CreateAdminRequest request) {
        return Admin.builder()
                .active(true)
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .canManageAdmins(request.isCanManageAdmins())
                .superAdmin(request.isSuperAdmin())
                .canManageOrders(request.isCanManageOrders())
                .canManageProducts(request.isCanManageProducts())
                .canManageStores(request.isCanManageStores())
                .canManageUsers(request.isCanManageUsers())
                .build();
    }
}
