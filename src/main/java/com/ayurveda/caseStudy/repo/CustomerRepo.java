package com.ayurveda.caseStudy.repo;

import com.ayurveda.caseStudy.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository//this interface is responsible for data access
public interface CustomerRepo extends JpaRepository<Customer, Long> {


    // below method is eqivalent to :
    //1. SQL:SELECT * FROM customer WHERE email = ?
    //2. JPQL: @Query("SELECT c FROM Customer c WHERE c.email = ?1")
    Optional<Customer> findCustomerByEmail(String email);
}
