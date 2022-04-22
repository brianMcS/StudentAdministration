/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.StudentAdministration.service;

import com.example.StudentAdministration.model.Admin;
import com.example.StudentAdministration.repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author brian
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> getALLAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public void addAdmin(Admin admin) {
        this.adminRepository.save(admin);
    }

    @Override
    public Admin getAdminById(long id) {
        Optional<Admin> optional = adminRepository.findById(id);
        Admin admin = null;
        if (optional.isPresent()) {
            admin = optional.get();
        } else {
            throw new RuntimeException(" admin not found for id :: " + id);
        }
        return admin;
    }

}
