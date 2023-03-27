package com.example.LoanManagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.LoanManagement.exception.ApplicationException;
import com.example.LoanManagement.model.CustomerDetails;
import com.example.LoanManagement.model.LoanProduct;
import com.example.LoanManagement.service.LoanEligibilityService;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Controller
@ControllerAdvice
public class LoanEligibilityController {
    @Autowired
    LoanEligibilityService loanEligibilityService;


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHomePage(Model model) {
        CustomerDetails customerDetails = new CustomerDetails();
        model.addAttribute("customerDetails", customerDetails);
        return "loanEligibility";
    }

    @RequestMapping(value = "/eligibilityCheck", method = RequestMethod.POST)

@ModelAttribute
    public String getLoanProducts(Model model,
                                  HttpServletRequest request,
                                  HttpServletResponse response,
                                  @Validated CustomerDetails customerDetails,
                                  @NotNull BindingResult result) throws ApplicationException {
        if (!result.hasErrors()) {
            List<LoanProduct> data = new ArrayList<LoanProduct>();
            data = loanEligibilityService.checkEligibleLoanProducts(customerDetails);
            if (data.isEmpty()) {
             model.addAttribute("msg","Sorry,no loan products matching your profile.");
            }else{
              model.addAttribute("data",data);
                model.addAttribute("msg","Congratulations.You are Eligible for the below Loan Products:");
            }
        }
        return (result.hasErrors() ? "loanEligibility" : "results");
    }

    @ModelAttribute("cityList")
    public List<String> getCities() {
        List<String> cityList = new ArrayList<String>();
        cityList.add("");
        cityList.add("Delhi");
        cityList.add("Chennai");
        cityList.add("Mumbai");
        cityList.add("Bangalore");
        return cityList;
    }

    @ModelAttribute("employeeList")
    public List<String> getEmploymentTypes() {
        List<String> employeeList = new ArrayList<String>();
        employeeList.add("");
        employeeList.add("Salaried");
        employeeList.add("Self-Employed");
        employeeList.add("ContractualEmployment");
        employeeList.add("Student");
        employeeList.add("Pensioner");
        return employeeList;
    }

    @ModelAttribute("genderList")
    List<String> getGenderOptions() {
        List<String> genderList = new ArrayList<String>();
        genderList.add("Male");
        genderList.add("Female");
        return genderList;
    }
}