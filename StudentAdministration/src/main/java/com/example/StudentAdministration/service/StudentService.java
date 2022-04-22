/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.StudentAdministration.service;

import com.example.StudentAdministration.model.Student;
import java.util.List;

/**
 *
 * @author brian
 */
public interface StudentService {

    List<Student> getALLStudents();

    void addStudent(Student student);

    Student getStudentById(String kNumber);

    void deleteStudentById(String kNumber);
}
