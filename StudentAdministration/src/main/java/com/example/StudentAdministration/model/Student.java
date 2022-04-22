/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.StudentAdministration.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author brian
 */
@Entity
public @Data
class Student implements Serializable {

    @Id
    private String kNumber;

    private String fName;

    private String lName;

    private String courseName;

    private String email;

    private String mobile;

    private String address1;

    private String address2;

    private String Town;

    private String City;

    private String County;
}
