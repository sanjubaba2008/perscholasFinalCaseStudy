package com.ayurveda.caseStudy.controllers;

import com.ayurveda.caseStudy.models.Customer;
import com.ayurveda.caseStudy.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller

public class CustomerController {

    final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/registercustomer")
    public String showRegistrationPage(Model model){
        log.warn("requested registercustomer.html");
        model.addAttribute("thecustomer", new Customer());
        return "registercustomer";

    }

    //I used PostMapping to add new resources in my system, In this I want to
    //add a new Customer
    @PostMapping("/registercustomer")
    public String showRegistrationData(@ModelAttribute("thecustomer") @Valid Customer customer, BindingResult bindingResult, Model model){
        log.warn("post request");
        if(bindingResult.hasErrors()){
            log.warn(bindingResult.getAllErrors().toString());
            return "registercustomer";

        }
        model.addAttribute("thecustomer",customer) ;
        customerService.saveCustomer(customer);

        return "result";
    }






   /* @PostMapping
    public void registerNewCustomer(@RequestBody Customer customer){

        customerService.addNewCustomer(customer);
    }*/

    @DeleteMapping(path="/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long customerId){
       customerService.deleteCustomer(customerId);

    }

    //Put is used when we want to update a resource in your system
    //for e.g we are updating name and email
    @ResponseBody
    @PutMapping(path = "/{customerId}")
    public void updateCustomer(
            @PathVariable("customerId") Long customerId,
            @RequestParam(required = false,name = "firstName") String firstName,
            @RequestParam(required = false,name = "lastName") String lastName,
            @RequestParam(required = false,name = "email") String email){
        log.warn("customerId= "+ customerId +" firstName "+firstName +"lastName "+lastName +" email" + email);
        customerService.updateCustomer(customerId,firstName,lastName,email);

    }
}
