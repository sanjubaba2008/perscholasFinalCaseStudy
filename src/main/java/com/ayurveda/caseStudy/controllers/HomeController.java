package com.ayurveda.caseStudy.controllers;

import com.ayurveda.caseStudy.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String showIndex(){
        log.warn("requested index.html");
        return "index";
    }




    @GetMapping("/contact")
    public String showContactPage(){
        log.warn("requested contact.html");
        return "contact";

    }

    @GetMapping("/403")
    public String accessDenied(){
        return "403";
    }





}
