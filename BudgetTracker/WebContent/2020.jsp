<%@ page language="java" contentType="text/html;charset=Windows-31J"%>
<html>

<head><title>2020</title></head>

<body>

	You selected 2020!!!
	<form action="/BudgetTracker/BTMonthSelector" method="POST">
	
		
		<input type="radio" name="months" value="January"> January <br />
		<input type="radio" name="months" value="February"> February <br />
		<input type="radio" name="months" value="March"> March <br />
		
		
		<br /> <input type="submit" value="Submit">

	</form>

</body>

</html>