package com.codywilliams.web;

import java.util.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.codywilliams.dao.SubjectsDAO;
import com.codywilliams.models.Subjects;
@WebServlet(name ="SubjectsServlet", value = {"/SubjectsServlet","/newSubject","/insertSubject","/listSubjects"})
public class SubjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	SubjectsDAO subjectsDAO = new SubjectsDAO();
	 
     public SubjectsServlet() {
        
    	 super();
       }

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String action = request.getServletPath();
			System.out.println(action);
			
		try {
			switch(action) {
			
			case "/newSubject":
				newSubjectForm(request,response);
				break;
				
			case "/insertSubject":
				insertSubject(request,response);
				break;
				
			case "/listSubjects":
				listSubjects(request, response);
				
				default:
					listSubjects(request, response);
					break;
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
		
	private void insertSubject(HttpServletRequest request, HttpServletResponse response) throws IOException {
			Subjects subjects = new Subjects();
			subjects.setSubName(request.getParameter("SubName"));
			subjects.setSubClass(request.getParameter("SubClass"));
			subjectsDAO.insertSubject(subjects);
			response.sendRedirect("listSubjects");
	}

	private void newSubjectForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("newSubjectForm.jsp");
		dispatcher.forward(request, response);
		
		
	}

	private	void listSubjects(HttpServletRequest request, HttpServletResponse response )throws ServletException,IOException {
		
	
			List <Subjects> subjectsList = subjectsDAO.getAllSubjects();
			request.setAttribute("Subjects", subjectsList)	;
			RequestDispatcher dispatcher = request.getRequestDispatcher("subjects.jsp");
			dispatcher.forward(request, response);
		
			
		
	
		}
		
	}


