<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Class</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/insertClass">
	<input type="text" name="clsLetter" placeholder = "Class"/>
	<input type="Submit" value="Enter" />
	</form>
</body>
</html>