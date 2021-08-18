package com.ayurveda.caseStudy.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class LoginController {

    @GetMapping("/login/password")
    public String getForgetPasswordPage(){
        log.warn("requested newPassword.html");
        return "newPassword";
    }

}
