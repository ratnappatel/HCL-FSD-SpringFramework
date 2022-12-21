<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Customer List Page</h1>
<h2>Welcome <%=session.getAttribute("name") %></h2>
<a href="/logout">Logout</a>
</body>
</html>