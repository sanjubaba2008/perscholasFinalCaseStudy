package com.ayurveda.caseStudy.controllers;

import com.ayurveda.caseStudy.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class LoginController {

    CustomerService customerService;

    @Autowired
    public LoginController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }


   /* @PostMapping("/login")
    public String postLogin(Model model, @ModelAttribute("currentCustomer") @Valid Customer currentCustomer, BindingResult bindingResult){
        log.warn("Post login...");

        if (customerService.validateCustomer(currentCustomer)) {
            model.addAttribute("currentUser", currentCustomer);
            return "loginsuccess";
        }

        if (bindingResult.hasErrors()) {
            log.warn(bindingResult.getAllErrors().toString() + " There is an error with the username.");
        }

        return "login";
    }*/
    @GetMapping("/login/password")
    public String getForgetPasswordPage(){
        log.warn("requested newPassword.html");
        return "newPassword";
    }

    @GetMapping("/login/homepage")
    public String getHomePage(){

        return "/";
    }

    /*@GetMapping("error")
    public String error(){

        return "error";
    }*/

}
