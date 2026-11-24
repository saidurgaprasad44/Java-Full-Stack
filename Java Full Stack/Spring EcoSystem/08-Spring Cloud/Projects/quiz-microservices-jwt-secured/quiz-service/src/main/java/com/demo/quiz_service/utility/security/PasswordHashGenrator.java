package com.demo.quiz_service.utility.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashGenrator {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        System.out.println(encoder.encode("password123")); //sai's password in identity-db
        System.out.println(encoder.encode("password456")); //vaishu's password in identity-db
    }
}

