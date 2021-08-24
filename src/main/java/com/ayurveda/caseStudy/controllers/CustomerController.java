package com.ayurveda.caseStudy.controllers;

import com.ayurveda.caseStudy.models.Customer;
import com.ayurveda.caseStudy.models.Product;
import com.ayurveda.caseStudy.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
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

    @GetMapping("/allcustomers")
    public String getCustomers(Model model) {
        List<Customer> customers= customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "allcustomers";
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
