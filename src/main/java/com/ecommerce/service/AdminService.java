package com.ecommerce.service;

import com.ecommerce.controller.vo.CreateAdminRequest;
import com.ecommerce.controller.vo.UpdateAdminRequest;
import com.ecommerce.domain.Admin;
import com.ecommerce.exception.NotFoundException;
import com.ecommerce.factory.AdminFactory;
import com.ecommerce.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminService {
    private final AdminRepository adminRepository;
    private final AdminFactory adminFactory;

    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdmin(Long adminId) {
        return adminRepository.findById(adminId).orElseThrow(() -> new NotFoundException("Admin not Found!"));
    }


    public Admin createAdmin(CreateAdminRequest request) {
        return adminRepository.save(adminFactory.createAdmin(request));
    }

    public Admin updateAdmin(Long adminId, UpdateAdminRequest request) {
        Admin admin = getAdmin(adminId);
        admin.update(request);
        return adminRepository.save(admin);
    }
}
