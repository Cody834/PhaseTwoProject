<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teachers List</title>
</head>
<body>
<%@ include file = "Header.jsp" %>
	<h2>Teachers List </h2>
		<table border="1" cellpadding ="10" cellspacing="0">
			<thead>
				<tr>
					<th>Teacher Id</th>
					<th>Teacher Name</th>
					<th>Teacher Class</th>
				</tr>
			</thead>
				<tbody>
					<c:forEach var="tea" items="${Teachers}">
						<tr>
							<td><c:out value="${tea.teaID}"/></td>
							<td><c:out value="${tea.teaName}"/></td>
							<td><c:out value="${tea.teaClass}"/></td>
						</tr>
				   	</c:forEach>
			</tbody>
		</table>
		<a href="<%=request.getContextPath()%>/newTeacher">Add New Teacher</a>
	</body>
</html>