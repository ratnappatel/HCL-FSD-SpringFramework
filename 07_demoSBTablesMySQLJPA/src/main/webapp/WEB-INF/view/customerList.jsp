<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="addCustomer">Add New Customer Details</a>
<table border="4" style="color:green">
	<tr><th>CustomerId</th><th>Customer Name</th><th>Customer Email</th><th>DOB</th>
	<th colspan="3">Loan Details</th><th>Operations</th></tr>
	<c:forEach var="c" items="${customers}">
        <tr>
           <td>${c.id}</td>
           <td>${c.name}</td>
           <td>${c.email}</td>
           <td>${c.dateOfBirth}</td>
           <td>${c.loan.id}</td>
           <td>${c.loan.title}</td>
           <td>${c.loan.amount} </td>
           <td>
           	<a href="/find?id=${c.id}">Edit</a>
           	<a href="/delete?id=${c.id}">Delete</a>
           </td>        
        </tr>
    </c:forEach>
</table>

</body>
</html>