package com.ecommerce.service;

import com.ecommerce.controller.vo.CreateCustomerRequest;
import com.ecommerce.controller.vo.UpdateCustomerRequest;
import com.ecommerce.domain.Customer;
import com.ecommerce.exception.NotFoundException;
import com.ecommerce.factory.CustomerFactory;
import com.ecommerce.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerFactory customerFactory;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long customerID) {
        return customerRepository.findById(customerID).orElseThrow(() -> new NotFoundException("Customer not Found!"));
    }


    public Customer createCustomer(CreateCustomerRequest request) {
        return customerRepository.save(customerFactory.createCustomer(request));
    }

    public Customer updateCustomer(Long customerID, UpdateCustomerRequest request) {
        Customer customer = getCustomer(customerID);
        customer.update(request);
        return customerRepository.save(customer);
    }
}
