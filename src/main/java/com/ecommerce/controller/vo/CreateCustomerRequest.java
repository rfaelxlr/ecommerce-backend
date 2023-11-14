package com.ecommerce.controller.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
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
public class CreateCustomerRequest {
    @NotEmpty
    private String name;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(min = 8, max = 50)
    private String password;

    @Size(min = 2, max = 2)
    @NotEmpty
    private String ddd;
    @Size(min = 9, max = 9)
    @NotEmpty
    private String phone;

    @Size(min = 11, max = 11)
    @NotEmpty
    private String identifier;

    private LocalDate birthDate;

    private boolean receiveEmails;
    private boolean receiveSms;
    private boolean receiveWhatsapp;
}
