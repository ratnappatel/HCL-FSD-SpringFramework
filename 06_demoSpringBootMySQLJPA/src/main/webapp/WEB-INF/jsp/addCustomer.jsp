<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Fill In Customer Details to Add them in Database</h1>
<form method=post action="addCustomer">
<!-- 	Enter Customer Id<input type=text name="id"><br> -->
	Enter Customer Name<input type=text name="name"><br>
	Enter Customer Email<input type=text name="email"><br>
	Enter Customer DateOfBirth<input type=date name="dateOfBirth" ><br>
	<input type=submit value="Add Customer"><input type=reset value="Claer Form">
</form>
</body>
</html>