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

import com.codywilliams.models.ClassReport2;

public class ClassReportServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    public ClassReportServlet2() {
       
   	 super();
      }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<ClassReport2> classReport2List = new ArrayList<ClassReport2>();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LearnersAcademydb","root","Chocol@te2020$");
			
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM ClassReport2;");
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				
				
				ClassReport2 classReport2 = new ClassReport2();
				classReport2.setClsSubject(rs.getString(2));
				classReport2.setClsStudents(rs.getString(3));
				classReport2.setClsTeachers(rs.getString(4));
				System.out.println(classReport2);
				classReport2List.add(classReport2);
			}
			System.out.println(classReport2List);	
			request.setAttribute("ClassReport2", classReport2List)	;
			RequestDispatcher dispatcher = request.getRequestDispatcher("classReport2.jsp");
			dispatcher.forward(request, response);
			connection.close();
			
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
	}
	
		
		
	}

}