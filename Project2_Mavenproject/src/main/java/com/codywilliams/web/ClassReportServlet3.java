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

import com.codywilliams.models.ClassReport3;


public class ClassReportServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    public ClassReportServlet3() {
       
   	 super();
      }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<ClassReport3> classReport3List = new ArrayList<ClassReport3>();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LearnersAcademydb","root","Chocol@te2020$");
			
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM ClassReport3;");
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				
				
				ClassReport3 classReport3 = new ClassReport3();
				classReport3.setClsSubject(rs.getString(2));
				classReport3.setClsStudents(rs.getString(3));
				classReport3.setClsTeachers(rs.getString(4));
				System.out.println(classReport3);
				classReport3List.add(classReport3);
			}
			System.out.println(classReport3List);	
			request.setAttribute("ClassReport3", classReport3List)	;
			RequestDispatcher dispatcher = request.getRequestDispatcher("classReport3.jsp");
			dispatcher.forward(request, response);
			connection.close();
			
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
	}
	
		
		
	}

}