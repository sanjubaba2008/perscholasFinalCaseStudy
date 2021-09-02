package com.ayurveda.caseStudy.services;

import com.ayurveda.caseStudy.models.Product;
import com.ayurveda.caseStudy.repo.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
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

    //to add new product in the database
    public void addNewProduct(Product product) {
        Optional<Product> productOptional = productRepo.findById(product.getPid());
        if(productOptional.isPresent()){
            throw new IllegalStateException("Id taken");

        }
        productRepo.save(product);
    }

    //to delete a product
    public void deleteProduct(Long id){
        boolean exists = productRepo.existsById(id);
        if(!exists){
            throw new IllegalStateException(
                    "product with id " + id + " does not exists");

        }
        productRepo.deleteById(id);
    }

    @Transactional
    public void updateProduct(Long productId, String name, Double price, Integer stock, String desc) {

        Product product = productRepo.findById(productId).orElseThrow(() -> new IllegalStateException(
                "product with id " + productId + " does not exist")
        );
        if(name != null && name.length() > 0 && !Objects.equals(product.getName(), name)){
            product.setName(name);
        }
        product.setPrice(price);
        product.setStock(stock);
        product.setDescription(desc);

        }


    }

