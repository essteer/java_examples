package com.essteer.bankingsystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.essteer.bankingsystem.repository.AccountMapRepository;
import com.essteer.bankingsystem.repository.Teller;
import com.essteer.bankingsystem.repository.UserMapRepository;

@SpringBootApplication
public class BankingSystemApplication implements CommandLineRunner {

	private static ApplicationContext ctx;

	public BankingSystemApplication(ApplicationContext ctx) {
		super();
		BankingSystemApplication.ctx = ctx;
	}

	public static void main(String[] args) {
		SpringApplication.run(BankingSystemApplication.class, args);

		AccountMapRepository acMapRepo = ctx.getBean(AccountMapRepository.class);
		UserMapRepository userMapRepo = ctx.getBean(UserMapRepository.class);
		Teller teller = ctx.getBean(Teller.class);

		System.out.println(acMapRepo);
		System.out.println(userMapRepo);
	}


	@Override
    public void run(String...args) throws Exception {
        System.out.println(" ApplicationRunner called");
    }

}
