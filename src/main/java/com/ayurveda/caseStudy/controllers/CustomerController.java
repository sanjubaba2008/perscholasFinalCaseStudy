package com.ayurveda.caseStudy.controllers;

import com.ayurveda.caseStudy.models.Customer;
import com.ayurveda.caseStudy.models.Product;
import com.ayurveda.caseStudy.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getcustomerbyemail")
    public String getCustomerByemail(Model model){
        model.addAttribute("customer",new Customer());
        return "customerbyemail";

    }

    @PostMapping("/getcustomerbyemail")
    public String postCustomerByEmail(Model model, @ModelAttribute("customer") Customer customer){

        customer =customerService.getSingleCustomer(customer.getEmail());
        model.addAttribute("customer", customer);

        return "customerinfo";
    }
}
