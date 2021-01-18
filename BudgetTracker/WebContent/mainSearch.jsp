<%@ page language="java" contentType="text/html;charset=Windows-31J"%>
<html>

<head>
<title>Search Main</title>
</head>

<body>

	Search Main Page
	<br />

	<br /> Search
	<br /> 
	<br />
	<form action="./BudgetTracker" method="POST">
		 Year: <select name="year">     
			<option value="2020">2020</option>     
			<option value="2021">2021</option>     
			<option value="2022">2022</option>
		</select> 
		<br /> <br /> Month: <select name="month">     
			<option value="Jan">January</option>     
			<option value="Feb">February</option>     
			<option value="Mar">March</option>
		</select>
		<br /> <br />
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
	<br /> Search by Store Name


	<form action="/BudgetTracker" method="POST">


		<br> <input type="hidden" name="mode"
			value="searchByStoreNameDescJan2020"> <input type="submit"
			value="Search">
	</form>

	Search by Type


	<form action="/BudgetTracker" method="POST">

		<br> <input type="hidden" name="mode"
			value="searchByTypeDescJan2020"> <input type="submit"
			value="Search">
	</form>

	<br /> Total Sum of January 2020


	<form action="/BudgetTracker" method="POST">

		<br> <input type="hidden" name="mode"
			value="searchByTotalSumOfJan2020"> <input type="submit"
			value="Search">
	</form>

	<br /> Ambiguous Retrieval by Product Name

	<br />
	<br />


	<form action="/BudgetTracker" method="POST">

		Product Name: <input type="text" name="productName"> <br /> <br>
		<input type="hidden" name="mode"
			value="likeSearchByProductNameJan2020"> <input type="submit"
			value="Search">

	</form>

	<form action="mainInsert.jsp" method="POST">
		<br> <input type="submit" value="Insert"> <br /> <br />
	</form>


</body>

</html>