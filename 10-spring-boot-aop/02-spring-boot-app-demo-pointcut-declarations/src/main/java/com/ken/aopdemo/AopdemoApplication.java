package com.ken.aopdemo;

import com.ken.aopdemo.dao.AccountDAO;
import com.ken.aopdemo.dao.MembershipDAO;
import com.ken.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortuneService trafficFortuneService) { // automatically inject dependency
		return runner -> {
			// demoTheBeforeAdvice(accountDAO, membershipDAO);
			// demoTheAfterReturningAdvice(accountDAO);
			// demoTheAfterThrowingAdvice(accountDAO);
			// demoTheAfterAdvice(accountDAO);
			// demoTheAroundAdvice(trafficFortuneService);
			// demoTheAroundAdviceHandleException(trafficFortuneService);
			demoTheAroundAdviceRethrowException(trafficFortuneService);
		};

	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdviceRethrowException");
		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdviceHandleException");
		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdvice");
		System.out.println("Calling getFortune()");
		String data = trafficFortuneService.getFortune();

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;

		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = false;

			accounts = accountDAO.findAccounts(tripWire);

		} catch (Exception exc) {
			System.out.println("\n\nMain Program: .. caught exception: " + exc);
		}

		System.out.println("\n\nMain Program: demoTheAfterAdvice");
		System.out.println("---");
		System.out.println(accounts);
		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;

		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;

			accounts = accountDAO.findAccounts(tripWire);

		} catch (Exception exc) {
			System.out.println("\n\nMain Program: .. caught exception: " + exc);
		}

		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("---");
		System.out.println(accounts);
		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
		List<Account> accounts = accountDAO.findAccounts();

		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("---");
		System.out.println(accounts);
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		// call business method
		accountDAO.addAccount(new Account("John", "1"), true);
		accountDAO.doWork();

		accountDAO.setName("HelloWorld");
		accountDAO.setServiceCode("US");
		String name = accountDAO.getName();
		String serviceCode = accountDAO.getServiceCode();

		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();

	}
}
