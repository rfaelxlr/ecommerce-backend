package com.ecommerce.controller;

import com.ecommerce.controller.vo.CreateCustomerRequest;
import com.ecommerce.controller.vo.UpdateCustomerRequest;
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
}
