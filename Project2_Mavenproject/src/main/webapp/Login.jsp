<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<h2>Login Page</h2>
	
	
	<form action="AdminLoginServlet" method = "post">
	<input type = "text" name = "Username" placeholder = "Enter Username Here ..."/>
	<input type = "password" name = "Password" placeholder = "Enter Password Here ..." />
	<input type = "submit" value = "Login "/>
 </form>
</body>
</html>