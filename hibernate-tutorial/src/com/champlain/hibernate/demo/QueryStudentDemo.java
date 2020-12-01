package com.champlain.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.champlain.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//Step 1 - Create the session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//Step 2 - Create the session
		Session session = factory.getCurrentSession();
		
		try {
			
			// Start a transaction
			session.beginTransaction();
			
			// Query Student
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// Display the students / forEach loop
			System.out.println("\n\nShows everything on DB:");
			displayStudents(theStudents);
			
			// Query students lastname = "Doe"
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			
			// Display Results 
			System.out.println("\n\nOnly who's last name is 'Doe': ");
			displayStudents(theStudents);
			
			// Query students lastname='Doe' or firstname='daffy'
			theStudents = session.createQuery("from Student s where s.lastName='Doe'"
					+ "OR s.firstName='Daffy'").getResultList();
			// Display Results
			System.out.println("\n\nStudents who have the last name 'Doe' or first name 'Daffy'");
			displayStudents(theStudents);
			
			//Query students where email LIKE gmail.com
			theStudents = session.createQuery("from Student s where "
					+ "s.email LIKE '%gmail.com'").getResultList();
			
			// Display Results
			System.out.println("\n\nQuery by email LIKE gmail.com:");
			displayStudents(theStudents);
			System.out.println("\n\n");
			
			
			
			
			// Commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
