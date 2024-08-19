package com.essteer.contactdirectory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
// import org.springframework.context.annotation.Bean;

import com.essteer.contactdirectory.model.Contact;

@SpringBootApplication
public class ContactDirectoryApplication {

	private static ApplicationContext context;

	// @Autowired is implicit here, so not needed but can be placed
	public ContactDirectoryApplication(ApplicationContext context) {
		super();
		ContactDirectoryApplication.context = context;
	}

	public static void main(String[] args) {
		SpringApplication.run(ContactDirectoryApplication.class, args);

		Contact c1 = context.getBean(Contact.class);
		Contact c2 = context.getBean(Contact.class);
		System.out.println(c1);
		System.out.println(c2);

	}


	// this enables Contact to be accessed anywhere in the app
	// but we can use the @Component annotation in Contact.java instead
	// for classes from external libs, we must use @Bean - can't amend original class with @Component
	// @Bean  
	// public Contact contactBean() {
	// 	return new Contact();
	// }

}
