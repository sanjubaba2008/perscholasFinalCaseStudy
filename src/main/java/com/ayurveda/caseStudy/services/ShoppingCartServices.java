package com.ayurveda.caseStudy.services;

import com.ayurveda.caseStudy.models.CartItem;
import com.ayurveda.caseStudy.models.Customer;
import com.ayurveda.caseStudy.models.Product;
import com.ayurveda.caseStudy.repo.CartItemRepo;
import com.ayurveda.caseStudy.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServices {


    private CartItemRepo cartRepo;
    private ProductRepo productRepo;

    @Autowired
    public ShoppingCartServices(CartItemRepo cartRepo, ProductRepo productRepo) {

        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
    }

    public List<CartItem> listCartItems(Customer customer){

        return cartRepo.findByCustomer(customer);
    }
    public Integer addProduct(Long productId, Integer quantity, Customer customer){
        Integer addedQuantity = quantity;
        Product product = productRepo.findById(productId).get();

        CartItem cartItem = cartRepo.findByCustomerAndProduct(customer,product);
        if(cartItem!=null){
            addedQuantity = cartItem.getQuantity() + quantity;
            cartItem.setQuantity(addedQuantity);
        }else{
            cartItem = new CartItem();
            cartItem.setQuantity(quantity);
            cartItem.setCustomer(customer);
            cartItem.setProduct(product);
        }
        cartRepo.save(cartItem);

        return addedQuantity;
    }
}
