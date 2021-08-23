package com.ayurveda.caseStudy.repo;

import com.ayurveda.caseStudy.models.Customer;
import com.ayurveda.caseStudy.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

}