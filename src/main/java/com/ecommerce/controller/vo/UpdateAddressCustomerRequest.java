package com.ecommerce.controller.vo;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAddressCustomerRequest {
    private String name;
    @Size(min = 1, max = 8)
    private String zipcode;
    @Size(min = 1, max = 100)
    private String city;
    @Size(min = 2, max = 2)
    private String state;
    @Size(min = 1, max = 150)
    private String street;
    @Size(min = 1, max = 20)
    private String number;
    @Size(min = 1, max = 100)
    private String country;
    @Size(min = 1, max = 100)
    private String complement;

    private Boolean active;
}
