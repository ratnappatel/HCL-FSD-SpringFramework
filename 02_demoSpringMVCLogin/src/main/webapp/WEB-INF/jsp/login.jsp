<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login To My WebApplication</title>
</head>
<body>
		<form action="/login" method="post">
				Enter Name : <input type=text name="uname"><br><br>
				Enter Password : <input type=password name="password"><br><br>
				<input type=submit value="Login"> 
		</form>
</body>
</html>