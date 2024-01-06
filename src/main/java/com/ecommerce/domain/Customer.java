package com.ecommerce.domain;

import com.ecommerce.controller.vo.UpdateCustomerRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
@SuperBuilder
public class Customer extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2)
    private String ddd;
    @Column(length = 9)
    private String phone;

    @Column(length = 11)
    private String identifier;

    private LocalDate birthDate;

    private boolean receiveEmails;
    private boolean receiveSms;
    private boolean receiveWhatsapp;

    @OneToMany(mappedBy = "customer", orphanRemoval = true)
    private Set<Address> addresses = new LinkedHashSet<>();

    public void update(UpdateCustomerRequest request) {
        Optional.ofNullable(request.getName()).ifPresent(this::setName);
        Optional.ofNullable(request.getEmail()).ifPresent(this::setEmail);
        Optional.ofNullable(request.getPassword()).ifPresent(this::setPassword);
        Optional.ofNullable(request.getActive()).ifPresent(this::setActive);
        Optional.ofNullable(request.getBirthDate()).ifPresent(this::setBirthDate);
        Optional.ofNullable(request.getDdd()).ifPresent(this::setDdd);
        Optional.ofNullable(request.getPhone()).ifPresent(this::setPhone);
        Optional.ofNullable(request.getIdentifier()).ifPresent(this::setIdentifier);
        Optional.ofNullable(request.getReceiveEmails()).ifPresent(this::setReceiveEmails);
        Optional.ofNullable(request.getReceiveSms()).ifPresent(this::setReceiveSms);
        Optional.ofNullable(request.getReceiveWhatsapp()).ifPresent(this::setReceiveWhatsapp);
    }
}
