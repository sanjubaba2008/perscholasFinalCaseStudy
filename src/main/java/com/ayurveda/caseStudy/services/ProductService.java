package com.ayurveda.caseStudy.services;

import com.ayurveda.caseStudy.models.Product;
import com.ayurveda.caseStudy.repo.CustomerRepo;
import com.ayurveda.caseStudy.repo.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductService {

    private ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {

        this.productRepo = productRepo;
    }

    public List<Product> getListOfAllProducts(){
        List<Product> productList = productRepo.findAll();
        return productList;
    }

    public Product getSingleProduct(Long id){
       Product product = productRepo.getById(id);
       return product;

    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Optional<Product> findById(Long productId) {
        return productRepo.findById(productId);
    }
}
