package com.essteer.contactdirectory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.essteer.contactdirectory.model.Contact;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Long> {

}
