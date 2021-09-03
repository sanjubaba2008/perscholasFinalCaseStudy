package com.ayurveda.caseStudy.security;


import com.ayurveda.caseStudy.models.AuthGroup;
import com.ayurveda.caseStudy.models.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Slf4j
public class AppUserPrincipal implements UserDetails {

    private Customer customer;
    private List<AuthGroup> authGroups;

    @Autowired //I don't need @Autowired if its only one constructor, but no harm in doing so
    public AppUserPrincipal(Customer customer, List<AuthGroup> authGroup) {
        this.customer = customer;
        this.authGroups = authGroup;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //basically this is all the authorities you want to give
        //this particular user
        if(null == authGroups){
            return Collections.emptySet();
        }
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        authGroups.forEach(authGroup -> grantedAuthorities.add(new SimpleGrantedAuthority(authGroup.getAuthGroup())));
        return grantedAuthorities;
        //returning this I made a blueprint of 2 vital info and I will give to springboot in services
        //1. who is the user (his/her username and password)
        //2. list of user granted authorities that user admin role, hr role whatever
    }

    @Override
    public String getPassword() {
        return customer.getPassword();
    }

    @Override
    public String getUsername() {
        return customer.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
