package com.example.LoanManagement.model;

import org.jetbrains.annotations.NotNull;

public class CustomerDetails {

    @NotNull
    public String name;
    @NotNull
    public String gender;
    @NotEmpty
    public String email;
    @NotNull
    public Double monthlyIncome;
    @NotEmpty
    public String customerCity;
    @NotEmpty
    public String employmentType;
    @NotNull
    public Double desiredLoanAmount;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public Double getMonthlyIncome(){
        return monthlyIncome;
    }
    public void setMonthlyIncome(Double monthlyIncome){
        this.monthlyIncome=monthlyIncome;
    }
    public String getCustomerCity(){
        return customerCity;
    }
    public void setCustomerCity(String customerCity){
        this.customerCity=customerCity;
    }
    public String getEmploymentType(){
        return employmentType;
    }
    public void setEmploymentType(String employmentType){
        this.employmentType=employmentType;
    }
    public Double getDesiredLoanAmount(){
        return desiredLoanAmount;
    }
    public void setDesiredLoanAmount(Double desiredLoanAmount){
        this.desiredLoanAmount=desiredLoanAmount;
    }}
