package com.ayurveda.caseStudy.services;

import com.ayurveda.caseStudy.models.Customer;
import com.ayurveda.caseStudy.repo.CustomerRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service//I could use @Component instead of @Service, they are exactly the same thing, @service is more specific
//to tell CustomerService is a bean (meaning it has to be instantiated)
public class CustomerService  {
    private CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public void saveCustomer(Customer customer){

            customerRepo.save(customer);

    }
    public Customer getSingleCustomer(String email){
       Optional<Customer> customeroptional = customerRepo.findCustomerByEmail(email);
       if(customeroptional.isPresent()){
           Customer customer = customeroptional.get();
           return customer;
       }
       else return null;

    }
}
