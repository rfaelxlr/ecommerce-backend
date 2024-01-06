package com.ecommerce.controller;

import com.ecommerce.controller.vo.CreateAddressCustomerRequest;
import com.ecommerce.controller.vo.CreateCustomerRequest;
import com.ecommerce.controller.vo.UpdateAddressCustomerRequest;
import com.ecommerce.controller.vo.UpdateCustomerRequest;
import com.ecommerce.domain.Address;
import com.ecommerce.domain.Customer;
import com.ecommerce.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> getCustomers() {
        return ResponseEntity.ok(customerService.getCustomers());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<?> getCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(customerService.getCustomer(customerId));
    }

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody @Valid CreateCustomerRequest request) {
        Customer customer = customerService.createCustomer(request);
        return ResponseEntity.created(URI.create("/customers/" + customer.getId())).body(customer);
    }

    @PatchMapping("/{customerId}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long customerId, @RequestBody UpdateCustomerRequest request) {
        return ResponseEntity.ok(customerService.updateCustomer(customerId, request));
    }

    @GetMapping("/{customerId}/addresses")
    public ResponseEntity<?> getAddresses(@PathVariable Long customerId) {
        return ResponseEntity.ok(customerService.getAddresses(customerId));
    }

    @GetMapping("/{customerId}/addresses/{addressId}")
    public ResponseEntity<?> getAddress(@PathVariable Long customerId, @PathVariable Long addressId) {
        return ResponseEntity.ok(customerService.getAddress(addressId, customerId));
    }

    @PostMapping("/{customerId}/addresses")
    public ResponseEntity<?> createAddress(@PathVariable Long customerId, @RequestBody @Valid CreateAddressCustomerRequest request) {
        Address address = customerService.createAddress(customerId, request);
        return ResponseEntity.created(URI.create("/customers/" + customerId + "/addresses/" + address.getId())).body(address);
    }

    @PatchMapping("/{customerId}/addresses/{addressId}")
    public ResponseEntity<?> updateAddress(@PathVariable Long customerId, @PathVariable Long addressId, @RequestBody UpdateAddressCustomerRequest request) {
        return ResponseEntity.ok(customerService.updateAddress(addressId,customerId, request));
    }
}
