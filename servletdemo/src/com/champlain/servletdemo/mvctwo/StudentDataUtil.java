package com.champlain.servletdemo.mvctwo;

import java.util.*;

public class StudentDataUtil {
	public static List<Student> getStudents(){
		
		List<Student> students = new ArrayList<>();
		
		students.add(new Student("Mary", "Public", "mary@email.com"));
		students.add(new Student("John", "Doe", "john@email.com"));
		students.add(new Student("Ajay", "Rao", "rao@email.com"));
		
		
		return students;
	}
}
