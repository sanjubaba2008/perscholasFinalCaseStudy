package com.ayurveda.caseStudy.controllers;

import com.ayurveda.caseStudy.models.Product;
import com.ayurveda.caseStudy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class ProductController {

   final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String displayProducts (Model model) {
        model.addAttribute("products", productService.getListOfAllProducts());
        return "products";
    }

    @GetMapping("/getproductbyid")
    public String getProductById(Model model){
        model.addAttribute("product",new Product());
        return "productbyid";

    }
    @PostMapping("/getproductbyid")
    public String postproductById(Model model, @ModelAttribute("product") Product product){

        product =productService.getSingleProduct(product.getPid());
        model.addAttribute("product", product);

        return "productinfo";
    }





}
