package com.ecommerce.controller.vo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAddressCustomerRequest {
    @NotEmpty
    private String name;
    @NotEmpty
    @Size(min = 1, max = 8)
    private String zipcode;
    @NotEmpty
    @Size(min = 1, max = 100)
    private String city;
    @NotEmpty
    @Size(min = 2, max = 2)
    private String state;
    @NotEmpty
    @Size(min = 1, max = 150)
    private String street;
    @NotEmpty
    @Size(min = 1, max = 20)
    private String number;
    @NotEmpty
    @Size(min = 1, max = 100)
    private String country;
    @NotEmpty
    @Size(min = 1, max = 100)
    private String complement;
}
