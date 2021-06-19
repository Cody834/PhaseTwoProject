package com.codywilliams.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codywilliams.models.ClassReport;

public class ClassReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    public ClassReportServlet() {
       
   	 super();
      }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<ClassReport> classReportList = new ArrayList<ClassReport>();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LearnersAcademydb","root","Chocol@te2020$");
			
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM ClassReport;");
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				
				
				ClassReport classReport = new ClassReport();
				classReport.setClsSubject(rs.getString(2));
				classReport.setClsStudents(rs.getString(3));
				classReport.setClsTeachers(rs.getString(4));
				System.out.println(classReport);
				classReportList.add(classReport);
			}
			System.out.println(classReportList);	
			request.setAttribute("ClassReport", classReportList)	;
			RequestDispatcher dispatcher = request.getRequestDispatcher("classReport.jsp");
			dispatcher.forward(request, response);
			connection.close();
			
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
	}
	
		
		
	}

}