package com.ayurveda.caseStudy.controllers;

import com.ayurveda.caseStudy.models.Customer;
import com.ayurveda.caseStudy.models.Quote;
import com.ayurveda.caseStudy.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Controller
@Slf4j
public class HomeController {

    final CustomerService customerService;

    @Autowired //customerservice will be magically instantiated and injected into constructor
    public HomeController(CustomerService customerService){

        this.customerService = customerService;
    }

    //I used GetMapping to get resources from the system
    @GetMapping({"/","index"})//when a client request a home page this method will be triggered
    //and returns index.html file. client can either request "/" or "index"
    public String showIndex(RestTemplate restTemplate, Model model){
        log.warn("requested index.html");
        Quote quote = restTemplate.getForObject(
                "https://quoters.apps.pcfone.io/api/random", Quote.class);
        log.warn(quote.toString());
        model.addAttribute("quote", quote.getValue().getQuote());

        return "index";
    }


    @GetMapping("/register")
    public String showRegistrationPage(Model model){
        log.warn("requested registration.html");
        model.addAttribute("thecustomer", new Customer());
        return "registration";

    }

    //I used PostMapping to add new resources in my system, In this I want to
    //add a new Customer
    @PostMapping("/register")
    public String showRegistrationData(@ModelAttribute("thecustomer") @Valid Customer customer, BindingResult bindingResult, Model model){
        log.warn("post request");
        if(bindingResult.hasErrors()){
            log.warn(bindingResult.getAllErrors().toString());
            return "registration";

        }
        model.addAttribute("thecustomer",customer) ;
        customerService.saveCustomer(customer);

        return "result";
    }

    @GetMapping("/contact")
    public String showContactPage(){
        log.warn("requested contact.html");
        return "contact";

    }

    @GetMapping("/preview")
    public String getPreview(){
        return "preview";
    }

    //processing contact form
    @PostMapping("/process-contact")
    public String processContact(){

        return "contact";
    }




}
