<%@ page language="java" contentType="text/html;charset=Windows-31J"%>
<html>

<head>
<title>Search Main</title>
</head>

<body>

	Search Insert Page
	<br />
	<br /> Register
	<br />
	<br />
	<form action="BudgetTracker/add" method="POST">
		ID: <input type="text" name="id"> Date: <input type="text"
			name="date"> Store Name
		<%@include file="storelist.jsp"%>
		Product Name: <input type="text" name="productName"> Type
		<%@include file="productTypeList.jsp"%>
		Price: <input type="number" name="price"> <br> <br>
		<input type="hidden" name="mode" value="addJan2020"> <input
			type="submit" value="Regist">
	</form>

	<br />
	
	<form action="mainSearch.jsp" method="POST">
		<br> <input type="submit" value="Search"> <br />
		<br />
	</form>
	
	<br />
	
</body>

</html>