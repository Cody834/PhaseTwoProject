package com.codywilliams.web;

import java.util.List;
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.codywilliams.models.Teachers;
import com.codywilliams.dao.TeachersDAO;
@WebServlet(name ="TeacherServlet", value = { "/TeacherServlet " , "/newTeacher" , "/insertTeacher" , "/listTeachers"})
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	TeachersDAO teachersDAO = new TeachersDAO();
	 
     public TeacherServlet() {
        
    	 super();
       }

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String action = request.getServletPath();
			System.out.println(action);
			
		try {
			switch(action) {
			
			case "/newTeacher":
				newTeacherForm(request,response);
				break;
				
			case "/insertTeacher":
				insertTeacher(request,response);
				break;
				
			case "/listTeachers":
				listTeachers(request, response);
				
				
				default:
					listTeachers(request, response);
					break;
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
		
	

	private void insertTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
			Teachers teachers = new Teachers();
			teachers.setTeaName(request.getParameter("TeaName"));
			teachers.setTeaClass(request.getParameter("TeaClass"));
			teachersDAO.insertTeacher(teachers);
			response.sendRedirect("listTeachers");
			

	}

	private void newTeacherForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("newTeacherForm.jsp");
		dispatcher.forward(request, response);
		
		
	}

	private	void listTeachers(HttpServletRequest request, HttpServletResponse response )
			throws ServletException,IOException {
		
	
			List<Teachers> teachersList = teachersDAO.getAllTeachers();
			request.setAttribute("Teachers", teachersList)	;
			RequestDispatcher dispatcher = request.getRequestDispatcher("teachers.jsp");
			dispatcher.forward(request, response);
		
			
		
	
		}
		
	}


