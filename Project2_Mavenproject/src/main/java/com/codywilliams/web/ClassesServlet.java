package com.codywilliams.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codywilliams.dao.ClassesDAO;
import com.codywilliams.models.Classes;
@WebServlet(name ="ClassesServlet", value = { "/ClassesServlet " , "/newClass" , "/insertClass" , "/listClasses"})
public class ClassesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ClassesDAO classesDAO = new ClassesDAO();
	 
     public ClassesServlet() {
        
    	 super();
       }
     protected void service(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException {
 		
 			String action = request.getServletPath();
 			System.out.println(action);
 			
 		try {
 			switch(action) {
 			
 			case "/newClass":
 				newClassForm(request,response);
 				break;
 				
 			case "/insertClass":
 				insertClass(request,response);
 				break;
 				
 			case "/listClasses":
 				listClasses(request, response);
 				
 				default:
 					listClasses(request, response);
 					break;
 			}
 		}catch(Exception ex) {
 			System.out.println(ex.getMessage());
 		}
 	}
 		
 	private void insertClass(HttpServletRequest request, HttpServletResponse response) throws IOException {
 			Classes classes = new Classes();
 			classes.setClsLetter(request.getParameter("clsLetter"));
 			ClassesDAO.insertClass(classes);
 			response.sendRedirect("listClasses");
 	}

 	private void newClassForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
 		
 		RequestDispatcher dispatcher= request.getRequestDispatcher("newClassForm.jsp");
 		dispatcher.forward(request, response);
 		
 		
 	}

 	private	void listClasses(HttpServletRequest request, HttpServletResponse response )
 			throws ServletException,IOException {
 		
 	
 			List<Classes> classesList = ClassesDAO.getAllClasses();
 			request.setAttribute("Classes", classesList)	;
 			RequestDispatcher dispatcher = request.getRequestDispatcher("classes.jsp");
 			dispatcher.forward(request, response);
 		
 			
 		
 	
 		}
 		
}