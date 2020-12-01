package com.ipd22.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		// 1 - Loading the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2 - Retrieve the bean from spring container
		ICoach theCoach = context.getBean("mycoach",ICoach.class);
		
		// 3 - Call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// 4 - Close the context
		context.close();

	}

}
