<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title></head>
<body>
<h3>Welcome <h1>${user.name}</h1> </h3>
<table border=3>
<tr><th>Employee ID</th><th>Employee Name</th><th>Employee Salary</th><th>DepartmentNo</th><th>Edit</th><th>Delete</th></tr>
<c:forEach var="e" items="${emps}">
<tr>
   <td> <c:out value="${e.id}"/></td> 
   <td> <c:out value="${e.name}"/></td> 
    <td><c:out value="${e.salary}"/></td> 
    <td><c:out value="${e.dept}"/></td> 
    <td><a href="">Edit</a></td>
    <td><a href="">Update</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>