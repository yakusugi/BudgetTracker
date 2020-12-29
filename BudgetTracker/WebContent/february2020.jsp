<html>

<head><title>February</title></head>

<body>

	You selected February!!!
	
	<br/><br/>
	Register
	<br/><br/>
	<form action="/BudgetTracker/BTController" method="POST">
		ID: <input type="text" name="id">
		Date: <input type="text" name="date">
		Store Name <%@include file="storelist.jsp" %>
		Product Name: <input type="text" name="productName">
		Type <%@include file="productTypeList.jsp" %>	
		Price: <input type="number" name="price">
		<br>
		<br> <input type="hidden" name="mode" value="addFeb2020"> <input
			type="submit" value="Regist">
	</form>
	
	<br/><br/>
	Search
	<br/><br/>
	
	<form action="/BudgetTracker/BTSeearchController" method="POST">
		ID: <input type="text" name="id">
		Date: <input type="text" name="date">
		Store Name <%@include file="storelist.jsp" %>
		Product Name: <input type="text" name="productName">
		Type <%@include file="productTypeList.jsp" %>	
		Price: <input type="number" name="price">
		<br>
		<br> <input type="hidden" name="mode" value="searchFeb2020"> <input
			type="submit" value="Search">
	</form>

</body>

</html>