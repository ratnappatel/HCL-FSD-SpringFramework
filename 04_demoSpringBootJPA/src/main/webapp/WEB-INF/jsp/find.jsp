<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/find">
Enter Student Id<input type=text name="id"><br>
<input type=submit value="Find Student"><br>
<a href="/add">Add New Student Details</a><br> <!--  hyperlink will trigger get function bydefault -->
<a href="/update">Update Student Details</a><br>
<a href="/delete">Delete Student Details</a>
</form>
</body>
</html>