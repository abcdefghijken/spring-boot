package com.ken.aopdemo;

import com.ken.aopdemo.dao.AccountDAO;
import com.ken.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) { // automatically inject dependency
		return runner -> {
			demoTheBeforeAdvice(accountDAO, membershipDAO);
		};

	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		// call business method
		accountDAO.addAccount();
		membershipDAO.addSillyMember();
		accountDAO.doWork();
		membershipDAO.goToSleep();

		accountDAO.addAccount(new Account("John", "1"), true);
	}
}
