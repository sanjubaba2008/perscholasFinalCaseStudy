package com.ayurveda.caseStudy.repo;

import com.ayurveda.caseStudy.models.CartItem;
import com.ayurveda.caseStudy.models.Customer;
import com.ayurveda.caseStudy.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem,Integer> {

    public List<CartItem> findByCustomer(Customer customer);
    public CartItem findByCustomerAndProduct(Customer customer, Product product);
}
