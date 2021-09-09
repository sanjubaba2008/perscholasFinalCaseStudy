package com.ayurveda.caseStudy.controllers;

import com.ayurveda.caseStudy.models.Product;
import com.ayurveda.caseStudy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"cart"})
public class ProductController {

   final ProductService productService;



    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute("cart")
    public List<Product> initListProduct(){
        return new ArrayList<Product>();
    }

    @GetMapping("/products")
    public String displayProducts (Model model) {
        model.addAttribute("products", productService.getListOfAllProducts());
        return "products";
    }

    @PostMapping("/cart")
    public String postCart(Model model, @ModelAttribute("product") Product product){

        product =productService.getSingleProduct(product.getPid());
        model.addAttribute("product", product);

        return "productinfo";
    }


    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();

    }

    @PostMapping("/registerNewProduct")
    public void registerNewProduct(@RequestBody Product product){

        productService.addNewProduct(product);
    }

    @DeleteMapping(path = "/deleteProduct/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId){
        productService.deleteProduct(productId);

    }

    @PutMapping(value = "/updateProduct/{productId}")
    public void updateProduct(
            @PathVariable("productId") Long productId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) Integer stock,
            @RequestParam(required = false) String desc){
        productService.updateProduct(productId,name,price,stock,desc);

    }


}
