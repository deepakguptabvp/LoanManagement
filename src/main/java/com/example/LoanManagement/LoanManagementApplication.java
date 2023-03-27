package com.example.LoanManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
		(basePackages = {"com.example.LoanManagement","com.example.LoanManagement.controller", 
		"com.example.LoanManagement.model","com.example.LoanManagement.service",
		"com.example.LoanManagement.exception"})
public class LoanManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoanManagementApplication.class, args);
    }
    	
    
}
