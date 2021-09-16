package com.ayurveda.caseStudy.controllers;


import com.ayurveda.caseStudy.models.Customer;
import com.ayurveda.caseStudy.models.Product;
import com.ayurveda.caseStudy.services.CustomerService;
import com.ayurveda.caseStudy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("console")
public class AdminController {

    private CustomerService customerService;
    private ProductService productService;

    @Autowired
    public AdminController(CustomerService customerService,ProductService productService ) {
        this.customerService = customerService;
        this.productService = productService;
    }

    @GetMapping("/getallcustomers")
    public String getCustomers(Model model) {
        List<Customer> customers= customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "allcustomers";
    }

    @PreAuthorize("hasAuthority('WRITE')")
    @GetMapping("/getcustomerbyemail")
    public String getCustomerByemail(Model model){
        model.addAttribute("customer",new Customer());
        return "customerbyemail";

    }
    @PostMapping("/getcustomerbyemail")
    public String postCustomerByEmail(Model model, @ModelAttribute("customer") Customer customer){

        customer =customerService.getSingleCustomer(customer.getEmail());
        model.addAttribute("customer", customer);

        return "customerinfo";
    }

    @GetMapping("/getallproducts")
    public String getProducts(Model model) {
        List<Product> products= productService.getAllProducts();
        model.addAttribute("products", products);
        return "allproducts";
    }

    @PreAuthorize("hasAuthority('WRITE')")
    @GetMapping("/getproductbyid")
    public String getProductById(Model model){
        model.addAttribute("product",new Product());
        return "productbyid";

    }


    @PostMapping("/getproductbyid")
    public String postproductById(Model model, @ModelAttribute("product") Product product) {

        product = productService.getSingleProduct(product.getPid());

        String myString = "";
        if (product == null) {
            myString = "there is no such product id";
            model.addAttribute("message", myString);
            return "error";
        }
        model.addAttribute("product", product);
        return "productinfo";
    }



}
