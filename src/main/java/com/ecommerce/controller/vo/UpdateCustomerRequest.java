package com.ecommerce.controller.vo;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {
    private String name;
    @Email
    private String email;

    private String password;

    @Size(min = 2, max = 2)
    private String ddd;
    @Size(min = 9, max = 9)
    private String phone;

    @Size(min = 11, max = 11)
    private String identifier;

    private LocalDate birthDate;

    private Boolean receiveEmails;
    private Boolean receiveSms;
    private Boolean receiveWhatsapp;
    private Boolean active;

}
