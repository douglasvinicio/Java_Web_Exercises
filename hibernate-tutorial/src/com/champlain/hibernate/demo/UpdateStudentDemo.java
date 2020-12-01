package com.champlain.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.champlain.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		//Step 1 - Create the session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//Step 2 - Create the session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 1;
			
			// New session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//Retrieve student based on the id : primary key 
			System.out.println("\nGetting student with id: " + studentId);
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student..");
			myStudent.setFirstName("Scooby");
			myStudent.setLastName("Doo");
			
			//Commit the Transaction
			session.getTransaction().commit();
			System.out.println("Done 1st!");
			
			
			// New code
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			// Update email for all students
			System.out.println("Update student set email=foo@gmail.com");
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//Commit the Transaction
			session.getTransaction().commit();
			System.out.println("Done 2nd!\n\n");
			System.out.println("SELECT * FROM Student:\n");
			extracted(theStudents);
			
			
			
			
		}
		finally {
			factory.close();
		}
		
	}

	private static void extracted(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
