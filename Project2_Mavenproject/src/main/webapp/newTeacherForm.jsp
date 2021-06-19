<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/insertTeacher">
	<input type="text" name="TeaName" placeholder = "Teacher Name"/>
	<input type="text" name="TeaClass" placeholder ="Teacher Class"/>
	<input type="Submit" value="Enter" />

</form>
</body>
</html>