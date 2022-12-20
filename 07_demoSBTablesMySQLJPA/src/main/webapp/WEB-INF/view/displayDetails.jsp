<%@ page errorPage="error.jsp" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method=post action="update">
	
		Customer ID :<input type=text name="cid" value=${cust.id } readonly><br>
		Customer Name :<input type=text name="name" value=${cust.name }><br>
		Customer Email :<input type=text name="email" value=${cust.email }><br>
		Customer DateOfBirth :<input type=date name="dateOfBirth" value=${cust.dateOfBirth }><br>
		<h3>Loan Details</h3>
		
		Loan ID : <input type=text name="lid" value=${cust.loan.id } readonly><br>
		Loan Type: <input type=text name="title" value=${cust.loan.title }><br>
		Loan Amount: <input type=text name="amount" value=${cust.loan.amount }><br>
		<input type=submit value="Update">
	</form>

</body>
</html>