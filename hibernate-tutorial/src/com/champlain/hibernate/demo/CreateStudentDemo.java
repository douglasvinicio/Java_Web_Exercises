package com.champlain.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.champlain.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		//Step 1 - Create the session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//Step 2 - Create the session
		Session session = factory.getCurrentSession();
		
		try {
			
			// 1 - Create student object
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Michael","Jordan","jordan@gmail.com");
			
			// 2 - Start a transaction
			session.beginTransaction();
			
			// 3 - Save the student object
			System.out.println("Saving the student obj...");
			session.save(tempStudent);
			
			// 4 - Commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		
	}

}
