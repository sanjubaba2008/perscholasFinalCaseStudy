package com.ayurveda.caseStudy.controllers;

import com.ayurveda.caseStudy.models.Cart;
import com.ayurveda.caseStudy.models.Customer;
import com.ayurveda.caseStudy.models.Product;
import com.ayurveda.caseStudy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

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
    @PostMapping("/cart")
    public String postCart(Model model, @ModelAttribute("product") Product product){

        product =productService.getSingleProduct(product.getPid());
        model.addAttribute("product", product);

        return "productinfo";
    }
    @GetMapping("/allproducts")
    public String getProducts(Model model) {
        List<Product> products= productService.getAllProducts();
        model.addAttribute("products", products);
        return "allproducts";
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
