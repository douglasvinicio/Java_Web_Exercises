package com.champlain.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.champlain.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			int studentId = 5;
			
			// New session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			System.out.println("\nSELECT * FROM student:");
			List <Student> allStudents = session.createQuery("from Student").getResultList();
			
			for(Student eachStudent : allStudents) {
				System.out.println(eachStudent);
			}
			
			
			// Retrieve student based on the id : primary key
			//System.out.println("\n\nGetting student with id: " + studentId);
			//Student myStudent = session.get(Student.class, studentId);
			
			// Delete Student
			//System.out.println("Deleting the student : " + myStudent);
			//session.delete(myStudent);
			
			
			System.out.println("\n\nDeleting id = 4 with createQuery..");
			session.createQuery("delete from Student where id=4").executeUpdate();
			
			
			
			
			allStudents = session.createQuery("from Student").getResultList();
			System.out.println("\n\nAll results after the delete : ");
			for(Student eachStudent:allStudents) {
				System.out.println(eachStudent);
			}
			// Commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		
	}

}
