<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students List</title>
</head>
<body>
		<%
			session = request.getSession(false);
		if(session.getAttribute("uname") == null){
			response.sendRedirect("Login.jsp");
		}
		%>
		

<%@ include file = "Header.jsp" %>
<br/>
<h2>Students List </h2>
	<table border="1" cellpadding ="10" cellspacing="0">
		<thead>
			<tr>
				<th>Student Id</th>
				<th>Student Name</th>
				<th>Class</th>
			</tr>
		</thead>
				<tbody>
					<c:forEach var="stud" items="${Students}">
					<tr>
						<td><c:out value="${stud.studID}"/></td>
						<td><c:out value="${stud.studName}"/></td>
						<td><c:out value="${stud.studClass}"/></td>
						
				        </tr>
				   	</c:forEach>
			</tbody>
		</table>
	</body>
</html>