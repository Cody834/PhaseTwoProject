<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Classes List</title>
</head>
<body>
<%@ include file = "Header.jsp" %>
<h2>Classes List </h2>
	<table border="1" cellpadding ="10" cellspacing="0">
		<thead>
			<tr>
				<th>Class </th>
			</tr>
		</thead>
				<tbody>
					<c:forEach var="cls" items="${Classes}">
					<tr>
						<td><c:out value="${cls.clsLetter}"/></td>
				    </tr>
				   	</c:forEach>
			</tbody>
		</table>
		<a href="<%=request.getContextPath()%>/newClass">Add New Class</a>
	</body>
</html>