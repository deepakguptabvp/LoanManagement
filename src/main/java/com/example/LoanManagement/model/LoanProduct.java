package com.example.LoanManagement.model;

public class LoanProduct {

    public String bankName;
    public String loanProductName;
    public Double maxLoanAmount;
    public Integer tenure;
    public Double interest;
    public Double monthlyInstallment;


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getLoanProductName() {
        return loanProductName;
    }

    public void setLoanProductName(String loanProductName) {
        this.loanProductName = loanProductName;
    }

    public Double getMaxLoanAmount() {
        return maxLoanAmount;
    }


    public void setMaxLoanAmount(Double maxLoanAmount) {
        this.maxLoanAmount = maxLoanAmount;
    }


    public Integer getTenure() {
        return tenure;
    }

    public void setTenure(Integer tenure) {
        this.tenure = tenure;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Double getMonthlyInstallment() {
        return monthlyInstallment;
    }

    public void setMonthlyInstallment(Double monthlyInstallment) {
        this.monthlyInstallment = monthlyInstallment;
    }

}
