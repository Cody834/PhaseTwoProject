<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Class C Report</title>
</head>
<body>
<%@ include file = "Header.jsp" %>
<h2>Class C Report </h2>
	<h3>Teacher : Michael</h3>
		<table border="1" cellpadding = "10" cellspacing="0">
			<thead>
				<tr>
					<th>Subjects</th>
				</tr>
			</thead>
				<tbody>
					<c:forEach var="cls" items="${ClassReport3}">
				   	<tr>
						<td><c:out value="${cls.clsSubject}"/></td>				   	
				   	</tr>
				   	</c:forEach>
				</tbody>
		</table>
		<br></br>
		<table border="1" cellpadding = "10" cellspacing="0">
			<thead>
				<tr>
					<th>Students</th>
				</tr>
			</thead>
				<tbody>
					<c:forEach var="cls" items="${ClassReport3}">
				   	<tr>
						<td><c:out value="${cls.clsStudents}"/></td>				   	
				   	</tr>
				   	</c:forEach>
				</tbody>
		</table>
</body>
</html>