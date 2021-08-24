package com.ayurveda.caseStudy.models;

import com.ayurveda.caseStudy.services.ProductService;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j

public class Cart {

     List<Product> cartItems;

     @Autowired
     ProductService productService;

    @Autowired
    public Cart() {

        this.cartItems = new ArrayList<Product>();
    }

    public void addProductToCartByPID(Long pid) {
        Product product = getProductByProductID(pid);
        addToCart(product);
    }

    private Product getProductByProductID(Long pid) {
        Product product = null;
        List<Product> products = productService.getAllProducts();
        for (Product prod: products) {
            if (prod.getPid() == pid) {
                product = prod;
                break;
            }
        }
        return product;
    }

    private void addToCart(Product product) {
        cartItems.add(product);
    }

    public void removeProductByPID(Long pid) {
        Product prod = getProductByProductID(pid);
        cartItems.remove(prod);
    }

    public double calculateTotalPrice () {
        double total = 0.00d;
        for (Product prod: this.cartItems) {
            total += prod.getPrice();
        }
        return total;
    }

}
