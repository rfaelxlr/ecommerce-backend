package com.ecommerce.controller.vo;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAdminRequest {
    private String name;
    @Email
    private String email;

    private String password;

    private Boolean canManageProducts;
    private Boolean canManageUsers;

    private Boolean canManageOrders;

    private Boolean canManageStores;

    private Boolean superAdmin;

    private Boolean canManageAdmins;

    private Boolean active;
}
