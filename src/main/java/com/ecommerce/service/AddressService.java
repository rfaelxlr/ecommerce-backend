package com.ecommerce.service;

import com.ecommerce.controller.vo.CreateAddressCustomerRequest;
import com.ecommerce.controller.vo.UpdateAddressCustomerRequest;
import com.ecommerce.domain.Address;
import com.ecommerce.domain.Customer;
import com.ecommerce.exception.NotFoundException;
import com.ecommerce.factory.AddressFactory;
import com.ecommerce.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final AddressFactory addressFactory;

    public List<Address> getAddresses(Customer customer) {
        return addressRepository.findAllByCustomerId(customer.getId());
    }

    public Address getAddress(Long addressId, Long customerId) {
        return addressRepository.findByIdAndCustomerId(addressId,customerId).orElseThrow(() -> new NotFoundException("Address not Found!"));
    }


    public Address createAddress(Customer customer, CreateAddressCustomerRequest request) {
        return addressRepository.save(addressFactory.createAddress(request, customer));
    }

    public Address updateAddress(Long addressId, Long customerId, UpdateAddressCustomerRequest request) {
        Address address = getAddress(addressId, customerId);
        address.update(request);
        return addressRepository.save(address);
    }

}
