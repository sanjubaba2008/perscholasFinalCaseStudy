package com.ayurveda.caseStudy.services;

import com.ayurveda.caseStudy.models.Customer;
import com.ayurveda.caseStudy.repo.CustomerRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    //to add new customer in the database
    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepo.findCustomerByEmail(customer.getEmail());
        if(customerOptional.isPresent()){
            throw new IllegalStateException("Email taken");

        }
        customerRepo.save(customer);
    }

    //to delete customer
    public void deleteCustomer(Long id){
        boolean exists = customerRepo.existsById(id);
        if(!exists){
            throw new IllegalStateException(
                    "customer with id " + id + " does not exists");

        }
       customerRepo.deleteById(id);
    }
//    public Customer getCurrentlyLoggedInCustomer(Authentication authentication){
//        if(authentication == null) return null;
//        Customer customer = null;
//        Object principal = authentication.getPrincipal();
//
//        if(principal instanceof Customer)
//    }

    @Transactional //it means that I don't have to implement any JPQL query. when we have this
    //annotation, the entity goes to a managed state
    public void updateCustomer(Long customerId, String firstName, String lastName, String email) {

//        log.warn("beginning of the updateCustomer method");
//        Customer customer = customerRepo.findById(customerId).orElseThrow(() -> new IllegalStateException(
//                "customer with id " + customerId + " does not exist")
//        );
//        if(firstName != null && firstName.length() > 0 && !Objects.equals(customer.getFirstName(), firstName)){
//            customer.setFirstName(firstName);
//            log.warn("firstName changed"+firstName);
//        }
//
//        if(lastName != null && lastName.length() > 0 && !Objects.equals(customer.getLastName(), lastName)){
//            customer.setLastName(lastName);
//            log.warn("lastName changed"+lastName);
//        }
//        if(email != null && email.length() > 0 && !Objects.equals(customer.getEmail(), email)){
//            //check if the email has been taken or not
//            Optional<Customer> customerOptional = customerRepo.findCustomerByEmail(email);
//            if(customerOptional.isPresent()){
//                throw new IllegalStateException("email taken");
//
//
//            }
//            customer.setEmail(email);
//            log.warn("email changed"+email);
        //}
        Customer customerX = new Customer(customerId,firstName,lastName,email);
        customerRepo.save(customerX);
        log.warn("saving"+customerX);

    }
    public boolean validateCustomer(Customer customer) {
        Customer newCustomer = this.getSingleCustomer(customer.getEmail());

        if (newCustomer == null) {
            return false;
        }

        String custPassword = newCustomer.getPassword();

        if (custPassword.equals(customer.getPassword())) {
            return true;
        }
        else {
            return false;
        }
    }


}
