<%@ page language="java" contentType="text/html;charset=Windows-31J"%>
<html>

<head>
<title>January</title>
</head>

<body>

	You selected January!!!
	<br />
	<br /> Register
	<br />
	<br />
	<form action="/BudgetTracker/BTController" method="POST">
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
	<br /> Search
	<br />
	<br />

	<form action="/BudgetTracker/BTSeearchController" method="POST">
		ID: <input type="text" name="id"> Date: <input type="text"
			name="date"> Store Name
		<%@include file="storelist.jsp"%>
		Product Name: <input type="text" name="productName"> Type
		<%@include file="productTypeList.jsp"%>
		Price: <input type="number" name="price"> <br> <br>
		<input type="hidden" name="mode" value="searchJan2020"> <input
			type="submit" value="Search">
	</form>

	Advanced Search
	<br />
	<br /> 
	Search by Store Name


	<form action="/BudgetTracker/BTSeearchController" method="POST">


		<br> <input type="hidden" name="mode"
			value="searchByStoreNameDescJan2020"> <input type="submit"
			value="Search">
	</form>

	Search by Type


	<form action="/BudgetTracker/BTSeearchController" method="POST">

		<br> <input type="hidden" name="mode"
			value="searchByTypeDescJan2020"> <input type="submit"
			value="Search">
	</form>
	
	<br /> 
	
	Total Sum of January 2020


	<form action="/BudgetTracker/BTSeearchController" method="POST">

		<br> <input type="hidden" name="mode"
			value="searchByTotalSumOfJan2020"> <input type="submit"
			value="Search">
	</form>
	
	<br /> 
	
	Ambiguous Retrieval by Product Name
	
	<br/>
	<br/>


	<form action="/BudgetTracker/BTSeearchController" method="POST">
	
	Product Name: <input type="text" name="productName">
	
	<br/>
		<br> <input type="hidden" name="mode"
			value="likeSearchByProductNameJan2020"> <input type="submit"
			value="Search">
			
	</form>
	
	
</body>

</html>