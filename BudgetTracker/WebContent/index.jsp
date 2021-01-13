<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&display=swap"
	rel="stylesheet">
<style>
body {
	background-image: url(img/IMG_6886.jpg);
	background-position: center center;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	margin: 30px 0 0 100px;
}

h1 {
	font-family: 'Alfa Slab One', cursive;
	color: #54178a;
}

form {
	border-bottom: 5px solid red;
	width: 300px;
}

</style>

</head>
<body>

	<br>
	<h1>Budget Tracker</h1>

	<form action="/BudgetTracker/BTloginpage" method="POST">
		<input type="text" name="ID" placeholder="ID"> <br> <br>
		<input type="text" name="Password" placeholder="Password"> <br>
		<br> <input type="submit" value="Login"> <br />
		<br />
	</form>

	<h2 class="indexh2">Features</h2>
	<p></p>
	<ul class="indexul">
		<li>Input expense record in our database</li>
		<li>Retrieve the expense record from the database</li>
		<li>Sort the record by product name and store name</li>
		<li>Any sorts of sorting is possible</li>
	</ul>

</body>
</html>