<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Student Details are:</h1>
Student Id : ${s.id}<br>
Student Name : ${s.name}<br>
Student Stream : ${s.stream }<br>
<a href="/">Back</a>
</body>
</html>