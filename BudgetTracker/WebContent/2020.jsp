<%@ page language="java" contentType="text/html;charset=Windows-31J"%>
<html>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Anton&display=swap"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Josefin+Sans&display=swap"
	rel="stylesheet">
<head>
<title>2020</title>
</head>

<body>

	<h1>Welcome to 2020</h1>
	<form action="/BudgetTracker/BTMonthSelector" method="POST">

		<p>
			<input type="radio" name="months" value="January"> January <br />
			<input type="radio" name="months" value="February"> February
			<br /> <input type="radio" name="months" value="March"> March <br />
		</p>


		<br /> <input type="submit" value="Submit">

	</form>

</body>

</html>