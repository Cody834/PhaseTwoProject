<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/insertStudent">
	<input type="text" name="StudID" placeholder="Student Id"/>
	<input type="text" name="StudName" placeholder = "Student Name"/>
	<input type="text" name="StudClass" placeholder = "Student Class"/>
	<input type="Submit" value="Enter" />

</form>

</body>
</html>