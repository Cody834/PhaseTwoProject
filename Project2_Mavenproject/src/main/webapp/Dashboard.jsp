<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DashBoard</title>
</head>
	<body>
		
		<h2>Learners Academy</h2>

			<a href = "StudentsServlet">Student List</a>
			<br></br>
			<a href = "TeacherServlet">Teachers List</a>
			<br></br>
			<a href ="SubjectsServlet">Subjects List</a>
			<br></br>
			<a href ="ClassesServlet">Classes List</a>
			<br></br>
			<a href ="ClassReportServlet">Class A Report</a>
			<br></br>
			<a href ="ClassReportServlet2">Class B Report</a>
			<br></br>
			<a href ="ClassReportServlet3">Class C Report</a>
				<% 
	
					session = request.getSession(false);
					if(session != null){
						
					}else{
					response.sendRedirect("Login.jsp");
					}
				%>

	</body>
</html>