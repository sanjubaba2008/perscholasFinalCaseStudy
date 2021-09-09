package com.ayurveda.caseStudy.security;

import com.ayurveda.caseStudy.models.AuthGroup;
import com.ayurveda.caseStudy.models.Customer;
import com.ayurveda.caseStudy.repo.AuthGroupRepo;
import com.ayurveda.caseStudy.repo.CustomerRepo;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AppUserDetailsService implements UserDetailsService {
    CustomerRepo customerRepo;
    AuthGroupRepo authGroupRepo;

    @Autowired
    public AppUserDetailsService(CustomerRepo customerRepo, AuthGroupRepo authGroupRepo) {
        this.customerRepo = customerRepo;
        this.authGroupRepo = authGroupRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //here I tell spring security how do you go and access the user
        Optional<Customer> customer = customerRepo.findCustomerByEmail(s);
        if(customer.isEmpty()){
            throw new UsernameNotFoundException("No customer " + s);
        }
        List<AuthGroup> authGroups = authGroupRepo.findByCustomerId(customer.get().getId());
        log.warn(authGroups.toString());
        return new AppUserPrincipal(customer.get(), authGroups);
    }
}
