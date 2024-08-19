package com.essteer.contactdirectory.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component  // alternative to using @Bean in main method (in ContactDirectoryApplication.java)
@Scope("prototype")  // default is singleton, changing enables multiple instances to be obtained
public class Address {

    private String city;
    private String country;

    public Address() {
        super();
    }
    
    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    

}
