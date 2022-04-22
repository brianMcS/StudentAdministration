/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.StudentAdministration.controller;

import com.example.StudentAdministration.model.Student;
import com.example.StudentAdministration.service.StudentService;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author brian
 */
@Controller
public class studentController {

    @Autowired
    private StudentService studentService;
// display list of admin

    @GetMapping("/studentDetails")
    public String viewStudentList(Model model) {
        model.addAttribute("listStudents",
                studentService.getALLStudents());
        return "studentList";
    }

    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "add_student";
    }

    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute("student") Student student) {
//save admin to database
        studentService.addStudent(student);
        return "redirect:/";
    }

    @GetMapping("/showFormForStudentUpdate/{kNumber}")
    public String showFormForStudentUpdate(@PathVariable(value = "kNumber") String kNumber,
            Model model) {
// get admin from the service
        Student student = studentService.getStudentById(kNumber);
// set admin as a model attribute to pre-populate the form
        model.addAttribute("student", student);
        return "update_student";
    }

    @GetMapping("/deleteStudent/{kNumber}")
    public String deleteStudent(@PathVariable(value = "kNumber") String kNumber,
            Model model) {
        Student student = this.studentService.getStudentById(kNumber);
        studentService.deleteStudentById(kNumber);
        System.out.println(kNumber);
        model.addAttribute("listStudents", studentService.getALLStudents());
        return "studentList";
    }

}
