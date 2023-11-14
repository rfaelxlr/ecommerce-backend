package com.ecommerce.factory;

import com.ecommerce.controller.vo.CreateCustomerRequest;
import com.ecommerce.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerFactory {

    public Customer createCustomer(CreateCustomerRequest request) {
        return Customer.builder()
                .active(true)
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .birthDate(request.getBirthDate())
                .ddd(request.getDdd())
                .phone(request.getPhone())
                .identifier(request.getIdentifier())
                .receiveEmails(request.isReceiveEmails())
                .receiveSms(request.isReceiveSms())
                .receiveWhatsapp(request.isReceiveWhatsapp())
                .build();
    }
}
