package com.codywilliams.web;

import java.util.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codywilliams.dao.StudentsDAO;
import com.codywilliams.models.Students;
@WebServlet(name ="StudentsServlet", value = { "/StudentsServlet " , "/newStudent" , "/insertStudent" , "/listStudents"})
public class StudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	StudentsDAO studentsDAO = new StudentsDAO();
	 
     public StudentsServlet() {
        
    	 super();
       }

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String action = request.getServletPath();
			System.out.println(action);
			
		try {
			switch(action) {
			
			case "/newStudent":
				newStudentForm(request,response);
				break;
				
			case "/insertStudent":
				insertStudent(request,response);
				break;
				
			case "/listStudents":
				listStudents(request, response);
				
				default:
					listStudents(request, response);
					break;
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
		
	private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
			Students students = new Students();
			students.setStudName(request.getParameter("StudName"));
			students.setClass(request.getParameter("StudClass"));
			studentsDAO.insertStudent(students);
			response.sendRedirect("listStudents");
	}

	private void newStudentForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("newStudentForm.jsp");
		dispatcher.forward(request, response);
		
		
	}

	private	void listStudents(HttpServletRequest request, HttpServletResponse response )
			throws ServletException,IOException {
		
	
			List<Students> studentsList = studentsDAO.getAllStudents();
			request.setAttribute("Students", studentsList)	;
			RequestDispatcher dispatcher = request.getRequestDispatcher("students.jsp");
			dispatcher.forward(request, response);
		
			
		
	
		}
		
	}


