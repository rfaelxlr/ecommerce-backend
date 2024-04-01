package com.ecommerce.service;

import com.ecommerce.controller.vo.CreateAddressCustomerRequest;
import com.ecommerce.controller.vo.CreateCustomerRequest;
import com.ecommerce.controller.vo.PasswordRecoverCodeRequest;
import com.ecommerce.controller.vo.UpdateAddressCustomerRequest;
import com.ecommerce.controller.vo.UpdateCustomerRequest;
import com.ecommerce.domain.Address;
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
    private final AddressService addressService;
    private final EmailService emailService;

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

    public Address createAddress(Long customerId, CreateAddressCustomerRequest request) {
        Customer customer = getCustomer(customerId);
        return addressService.createAddress(customer, request);
    }

    public List<Address> getAddresses(Long customerId) {
        Customer customer = getCustomer(customerId);
        return addressService.getAddresses(customer);
    }

    public Address getAddress(Long addressId, Long customerId) {
        Customer customer = getCustomer(customerId);
        return addressService.getAddress(addressId,customer.getId());
    }

    public Address updateAddress(Long addressId, Long customerId, UpdateAddressCustomerRequest request) {
        Customer customer = getCustomer(customerId);
        return addressService.updateAddress(addressId,customer.getId(), request);
    }

    public void sendConfirmationCode(PasswordRecoverCodeRequest request) {
        emailService.passwordRecoverCode(request.getEmail());
    }
}
