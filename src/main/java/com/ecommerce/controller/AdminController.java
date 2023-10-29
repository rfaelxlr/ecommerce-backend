package com.ecommerce.controller;

import com.ecommerce.controller.vo.CreateAdminRequest;
import com.ecommerce.controller.vo.UpdateAdminRequest;
import com.ecommerce.domain.Admin;
import com.ecommerce.service.AdminService;
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
@RequestMapping("/admins")
@AllArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping
    public ResponseEntity<?> getAdmins() {
        return ResponseEntity.ok(adminService.getAdmins());
    }

    @GetMapping("/{adminId}")
    public ResponseEntity<?> getAdmin(@PathVariable Long adminId) {
        return ResponseEntity.ok(adminService.getAdmin(adminId));
    }

    @PostMapping
    public ResponseEntity<?> createAdmin(@RequestBody @Valid CreateAdminRequest request) {
        Admin admin = adminService.createAdmin(request);
        return ResponseEntity.created(URI.create("/admins/" + admin.getId())).body(admin);
    }

    @PatchMapping("/{adminId}")
    public ResponseEntity<?> updateAdmin(@PathVariable Long adminId, @RequestBody UpdateAdminRequest request) {
        return ResponseEntity.ok(adminService.updateAdmin(adminId, request));
    }
}
