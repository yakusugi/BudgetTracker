<%@ page language="java" contentType="text/html;charset=Windows-31J"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Success Page</title>
</head>
<body>
	<form action="/BudgetTracker/BTYearSelector" method="POST">
	
		
		<input type="radio" name="year" value="2020"> 2020 <br />
		<input type="radio" name="year" value="2021"> 2021 <br />
		<input type="radio" name="year" value="2022"> 2022 <br />
		
		
		<br /> <input type="submit" value="Submit">

	</form>

</body>
</html>