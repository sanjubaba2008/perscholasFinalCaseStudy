package com.ayurveda.caseStudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/","index"})//when a client request a home page this method will be triggered
    //and returns index.html file. client can either request "/" or "index"
    public String showIndex(){

        return "index";
    }
    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }


}
