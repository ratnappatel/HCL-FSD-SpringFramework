<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/update" method=POST>
		Enter Student ID <input type=text name="id"><br>
		Enter Student Name <input type=text name="name"><br>
		Enter Student Stream <input type=text name="stream"><br>
		<input type=submit value="Update Student"><input type=reset value="Clear Form">
	</form>
</body>
</html>