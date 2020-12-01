package com.ipd22.springdemo;

public class MyApp {
	public static void main(String[] args) {
		// 1 - Create the object
		
		ICoach bbalCoach = new TennisCoach();
		
		// 2 - Use the object
		System.out.println(bbalCoach.getDailyWorkout());
	}
}
