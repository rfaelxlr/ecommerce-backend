package com.ecommerce.domain;

import com.ecommerce.controller.vo.UpdateAddressCustomerRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Optional;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class Address extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(length = 8)
    private String zipcode;
    @Column(length = 100)
    private String city;
    @Column(length = 2)
    private String state;
    @Column(length = 150)
    private String street;
    @Column(length = 20)
    private String number;
    @Column(length = 100)
    private String country;
    @Column(length = 100)
    private String complement;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public void update(UpdateAddressCustomerRequest request) {
        Optional.ofNullable(request.getName()).ifPresent(this::setName);
        Optional.ofNullable(request.getZipcode()).ifPresent(this::setZipcode);
        Optional.ofNullable(request.getCity()).ifPresent(this::setCity);
        Optional.ofNullable(request.getState()).ifPresent(this::setState);
        Optional.ofNullable(request.getStreet()).ifPresent(this::setStreet);
        Optional.ofNullable(request.getNumber()).ifPresent(this::setNumber);
        Optional.ofNullable(request.getCountry()).ifPresent(this::setCountry);
        Optional.ofNullable(request.getComplement()).ifPresent(this::setComplement);
        Optional.ofNullable(request.getActive()).ifPresent(this::setActive);
    }
}
