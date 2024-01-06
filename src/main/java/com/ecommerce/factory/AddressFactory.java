package com.ecommerce.factory;

import com.ecommerce.controller.vo.CreateAddressCustomerRequest;
import com.ecommerce.domain.Address;
import com.ecommerce.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public class AddressFactory {

    public Address createAddress(CreateAddressCustomerRequest request, Customer customer) {
        return Address.builder()
                .active(true)
                .city(request.getCity())
                .name(request.getName())
                .state(request.getState())
                .complement(request.getComplement())
                .customer(customer)
                .number(request.getNumber())
                .street(request.getStreet())
                .country(request.getCountry())
                .zipcode(request.getZipcode()).build();
    }
}
