package com.ayurveda.caseStudy.controllers;

import com.ayurveda.caseStudy.models.CartItem;
import com.ayurveda.caseStudy.models.Customer;
import com.ayurveda.caseStudy.services.CustomerService;
import com.ayurveda.caseStudy.services.ShoppingCartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ShoppingCartController {

    private ShoppingCartServices cartServices;
    private CustomerService customerService;

    @Autowired
    public ShoppingCartController(ShoppingCartServices cartServices,CustomerService customerService) {
        this.cartServices = cartServices;
        this.customerService = customerService;
    }

    @GetMapping("/customer/cart")
    public String showShoppingCart(Model model,Customer customer){
        Customer newcustomer = customerService.getSingleCustomer(customer.getEmail());
        List<CartItem> cartItemList = cartServices.listCartItems(newcustomer);
        model.addAttribute("cartItems",cartItemList);

        return "shopping_cart";
    }

}
