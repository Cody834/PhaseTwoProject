<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subjects List</title>
</head>
<body>
		<%
			session = request.getSession(false);
		if(session.getAttribute("uname") == null){
			response.sendRedirect("Login.jsp");
		}
		%>
<%@ include file = "Header.jsp" %>
<h2>Subjects List </h2>
	<table border="1" cellpadding ="10" cellspacing="0">
		<thead>
			<tr>
				<th>Subject</th>
				<th>Class</th>
			</tr>
		</thead>
				<tbody>
					<c:forEach var="sub" items="${Subjects}">
					<tr>
						<td><c:out value="${sub.subName}"/></td>
						<td><c:out value="${sub.subClass}"/></td>
						
				        </tr>
				   	</c:forEach>
			</tbody>
		</table>
		<br></br>
		<a href="<%=request.getContextPath()%>/newSubject">Add New Subject</a>
	</body>
</html>