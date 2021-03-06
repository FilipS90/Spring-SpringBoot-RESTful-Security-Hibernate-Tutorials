package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterReturningApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO AccountDAO = 
				context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> accs = AccountDAO.findAccounts();
		System.out.println("\n\n Program: AfterReturningApp");
		System.out.println("----");
		
		System.out.println(accs);
		System.out.println("\n");
		
				
		// close the context
		context.close();
	}

}










