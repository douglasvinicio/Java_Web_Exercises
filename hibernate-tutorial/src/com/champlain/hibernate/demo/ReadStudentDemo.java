package com.champlain.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.champlain.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("Mickey","Mouse","mickey@abbott.com");
			
			// 2 - Start a transaction
			session.beginTransaction();
			
			// 3 - Save the student object
			System.out.println("Saving the student obj...");
			session.save(tempStudent);
			
			// 4 - Commit transaction
			session.getTransaction().commit();
			
			// New code for retrieve
			// 5 - Find out the student's id : primary key
			System.out.println("Saved student. Generated id: " + tempStudent.getId());
			
			// 6 - New session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//Retrieve student based on the id : primary key 
			System.out.println("\nGetting student with id: " + tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: " + myStudent);
			
			//Commit the Transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
		
	}

}
