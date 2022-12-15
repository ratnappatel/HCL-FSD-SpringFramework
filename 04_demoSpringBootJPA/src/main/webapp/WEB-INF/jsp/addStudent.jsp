<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><h1>Add New Student Details</h1>
	<form action="/add" method=POST>
		Enter Student ID <input type=text name="id"><br>
		Enter Student Name <input type=text name="name"><br>
		Enter Student Stream <input type=text name="stream"><br>
		<input type=submit value="Add Student"><input type=reset value="Clear Form">
	</form>
</body>
</html>