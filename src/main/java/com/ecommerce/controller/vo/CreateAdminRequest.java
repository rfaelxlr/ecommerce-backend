package com.ecommerce.controller.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdminRequest {
    @NotEmpty
    private String name;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(min = 8 , max = 50)
    private String password;

    private boolean canManageProducts = false;
    private boolean canManageUsers = false;

    private boolean canManageOrders = false;

    private boolean canManageStores = false;

    private boolean superAdmin = false;

    private boolean canManageAdmins = false;
}
