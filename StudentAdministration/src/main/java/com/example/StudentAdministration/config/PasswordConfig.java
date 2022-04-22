/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.StudentAdministration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author brian
 */
public class PasswordConfig {

    @Bean//initialises the method
    public PasswordEncoder passwordEncoder() {//passwordEncoder interface
        return new BCryptPasswordEncoder(10);//number is strength of encoding passwords
    }
}
