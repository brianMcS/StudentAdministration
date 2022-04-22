/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.StudentAdministration.service;

import com.example.StudentAdministration.model.Admin;
import java.util.List;

/**
 *
 * @author brian
 */
public interface AdminService {

    List<Admin> getALLAdmins();

    void addAdmin(Admin admin);

    Admin getAdminById(long id);
}
