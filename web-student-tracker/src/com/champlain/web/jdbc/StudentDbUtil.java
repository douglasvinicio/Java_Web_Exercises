package com.champlain.web.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.sql.DataSource;

public class StudentDbUtil {
	
	private DataSource dataSource;
	
	public StudentDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Student> getStudents() throws Exception{
		
		List<Student> students = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			//Get a Connection
			myConn = dataSource.getConnection();
			
			//Create SQL Statement
			String sql = "SELECT * FROM student ORDER BY last_name";
			
			myStmt = myConn.createStatement();
			
			//Execute query
			myRs = myStmt.executeQuery(sql);
			
			//Process the result set
			while(myRs.next()) {
				//Retrieve data from the result set
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				
				//Create a new student object
				Student tempStudent = new Student(id,firstName,lastName,email);
				
				//Add to the list of students
				students.add(tempStudent);
			}
			return students;
		}
		
		finally {
			//Close all JDBC Objects
			close(myConn, myStmt, myRs);
		}
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		
		
		try {
			if(myRs != null) {
				myRs.close();
			}
			
			if(myConn != null) {
				myConn.close();
			}
			if(myStmt != null) {
				myStmt.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	} 
} 
