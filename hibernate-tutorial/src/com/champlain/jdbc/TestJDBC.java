package com.champlain.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://127.0.0.1:3306/hb_student_tracker?useSSL=false&serverTimeZone=UTC";
		
		String user = "hbstudent";
		String password= "Progr@mming2020";
		
		try {
			System.out.println("Connecting to database: " + jdbcURL);
			Connection myConn = DriverManager.getConnection(jdbcURL,user,password); 
			System.out.println("Connection Sucessfull!");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
