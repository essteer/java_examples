package com.essteer.contactdirectory.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component  // alternative to using @Bean in main method (in ContactDirectoryApplication.java)
@Scope("prototype")  // default is singleton, changing enables multiple instances to be obtained
public class Contact {

    private long contactId;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    @Autowired  // 2 conditions needed for @Autowired to work: this class and injected class must both be beans
    private Address address;  // this is field injection, as opposed to constructor injection
    // field and constructor injection makes the dependency mandatory
    // injection can also be done with @Autowired at the setter method, which makes the dependency optional

    public Contact() {
        // Essential for any Spring Bean - a no-arg constructor
        super();
    }

    public Contact(long contactId, String firstName, String lastName, String phoneNumber) {
        super();
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Contact [contactId=" + contactId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
    }

    

}
