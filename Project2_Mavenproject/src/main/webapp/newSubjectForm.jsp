<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/insertSubject">
	<input type="text" name="SubName" placeholder = "Subject"/>
	<input type="text" name="SubClass" placeholder = "Subject Class"/>
	<input type="Submit" value="Enter" />

</form>

</body>
</html>