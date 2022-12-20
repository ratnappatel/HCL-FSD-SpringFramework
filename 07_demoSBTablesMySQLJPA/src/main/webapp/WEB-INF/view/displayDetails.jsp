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
Customer ID :<b>${cust.id }</b><br>
Customer Name :<b>${cust.name }</b><br>
Customer Email :<b>${cust.email }</b><br>
Customer DateOfBirth :<b>${cust.dateOfBirth }</b><br>
<h3>Loan Details</h3>

Loan ID : <b>${cust.loan.id}</b> <br>
Loan Type: <b>${cust.loan.title }</b><br>
Loan Amount: <b>${cust.loan.amount }</b>
</body>
</html>