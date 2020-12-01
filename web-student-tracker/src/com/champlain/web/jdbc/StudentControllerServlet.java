package com.champlain.web.jdbc;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDbUtil studentDbUtil;

	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();
		//Create DB Util and pass in the Conn pool / DataSource
		try {
			studentDbUtil = new StudentDbUtil(dataSource);
		}
		catch(Exception e) { 
			throw new ServletException(e);
		}
	} 
	
	/* 
	 doGet Method
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

	// List the students in MVC fashion
	try {
		listStudents(request,response);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	


	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// Get Students from db util
		List<Student> students = studentDbUtil.getStudents();
		
		// add students to the request
		request.setAttribute("STUDENT_LIST", students);
		
		//send JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		
		dispatcher.forward(request, response);
		
	}

}
