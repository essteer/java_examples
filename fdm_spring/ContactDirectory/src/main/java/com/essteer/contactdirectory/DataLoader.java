package com.essteer.contactdirectory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

// import com.essteer.contactdirectory.model.Contact;
import com.essteer.contactdirectory.repositories.ContactRepo;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private ContactRepo contactRepo;

    public DataLoader(ContactRepo contactRepo) {
        super();
        this.contactRepo = contactRepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Contact c1 = new Contact(1L, "john", "1234");
        // contactRepo.save(c1);

        contactRepo.findById(1L).ifPresent(contact -> {
            System.out.println("Found " + contact.getFirstName());
        });
    }

}
