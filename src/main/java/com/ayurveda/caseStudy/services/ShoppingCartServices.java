package com.ayurveda.caseStudy.services;

import com.ayurveda.caseStudy.models.CartItem;
import com.ayurveda.caseStudy.models.Customer;
import com.ayurveda.caseStudy.repo.CartItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServices {


    private CartItemRepo cartRepo;

    @Autowired
    public ShoppingCartServices(CartItemRepo cartRepo) {
        this.cartRepo = cartRepo;
    }

    public List<CartItem> listCartItems(Customer customer){
        return cartRepo.findByCustomer(customer);
    }
}
