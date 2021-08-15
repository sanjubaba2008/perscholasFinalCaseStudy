package com.ayurveda.caseStudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login/password")
    public String getForgetPasswordPage(){

        return "newPassword";
    }

}
