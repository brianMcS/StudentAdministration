/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.StudentAdministration.service;

import com.example.StudentAdministration.model.Student;
import com.example.StudentAdministration.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author brian
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepo;

    @Override
    public List<Student> getALLStudents() {
        return studentRepo.findAll();
    }

    @Override
    public void addStudent(Student student) {
        this.studentRepo.save(student);
    }

    @Override
    public Student getStudentById(String kNumber) {
        Optional<Student> optional = studentRepo.findById(kNumber);
        Student student = null;
        if (optional.isPresent()) {
            student = optional.get();
        } else {
            throw new RuntimeException(" student not found for kNumber :: " + kNumber);
        }
        return student;
    }

    @Override
    public void deleteStudentById(String kNumber) {
        this.studentRepo.deleteById(kNumber);
    }
}
