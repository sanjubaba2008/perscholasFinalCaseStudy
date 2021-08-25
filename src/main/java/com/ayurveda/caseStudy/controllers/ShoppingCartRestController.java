package com.ayurveda.caseStudy.controllers;

import com.ayurveda.caseStudy.services.CustomerService;
import com.ayurveda.caseStudy.services.ShoppingCartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingCartRestController {
    private ShoppingCartServices cartServices;
    private CustomerService customerService;

    @Autowired
    public ShoppingCartRestController(ShoppingCartServices cartServices, CustomerService customerService) {
        this.cartServices = cartServices;
        this.customerService = customerService;
    }


}
