<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Our E-Commerce Portal</h1>
	<form action="/login" method=post style="border: 2px solid green">
		Enter User ID<input type=text name="id"><br>
		Enter Password<input type=password name="password"><br>
		<input type=submit value="User Login"><input type=reset value="Reset"><br>
	</form>
	<a href="/register">New User Register</a>
</body>
</html>