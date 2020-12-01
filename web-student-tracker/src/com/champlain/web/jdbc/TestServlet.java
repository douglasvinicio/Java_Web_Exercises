package com.champlain.web.jdbc;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;




@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Define data-source / Connection Pool for Resource Injection
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step 1 - Set up the PrintWriter
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
		// Step 2 - Get a connection to the database
		Connection myConn = null;
		Statement myStatement = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			
			//Step 3 - Create SQL Statements 
			String sql = "SELECT * FROM student";
			myStatement = myConn.createStatement();
			
			//Step 4 - Execute SQL Query 
			myRs = myStatement.executeQuery(sql);
			
			//Step 5 - Process the result set
			while(myRs.next()) {
				String email = myRs.getString("email");
				out.println(email);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
