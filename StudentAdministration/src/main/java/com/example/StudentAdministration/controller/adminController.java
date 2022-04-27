/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.StudentAdministration.controller;

import com.example.StudentAdministration.model.Admin;
import com.example.StudentAdministration.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author brian
 */
@Controller
public class adminController {

    @Autowired
    private AdminService adminService;

// display list of admin
    @GetMapping("/admin")
    public String viewHomePage(Model model) {
        model.addAttribute("listAdmins", adminService.getALLAdmins());
        return "adminList";
    }

    @GetMapping("/showNewAdminForm")
    public String showNewAdminForm(Model model) {
        Admin admin = new Admin();
        model.addAttribute("admin", admin);
        return "add_admin";
    }

    @GetMapping("/adminSection")
    public String viewAdminSection(Model model) {

        return "adminSection";
    }

    @PostMapping("/addAdmin")
    public String addAdmin(@ModelAttribute("admin") Admin admin) {
//save admin to database
        adminService.addAdmin(admin);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id,
            Model model) {
// get admin from the service
        Admin admin = adminService.getAdminById(id);
// set admin as a model attribute to pre-populate the form
        model.addAttribute("admin", admin);
        return "update_admin";
    }
}
