<%@ page language="java" contentType="text/html;charset=Windows-31J"%>
<%@page import="info.budget.budgettracker.BudgetTrackerSearchLogic"%>

<html>

<head><title>Modify January</title></head>

<body>

	Modify Jan 2020!!!
	
	<%
	BudgetTrackerSearchLogic btSearchLogic = (BudgetTrackerSearchLogic) request.getAttribute("btSearchLogic");
	%>
	
	<br/><br/>
	Change(Modify)
	<br/><br/>
	<form action="/BudgetTracker/BTSeearchController" method="POST">
		ID: <input type="hidden" name="id"
			value="<%=btSearchLogic.getId()%>"> �iUnchangeable�j
		Date: <input type="text"name="date" value="<%=btSearchLogic.getDate()%>"> 
		Store Name�F <%@include file="storelist.jsp" %>
		</SELECT>
		Product Name�F<input type="text" name="productName" value="<%=btSearchLogic.getProductName()%>">
		Type�F <%@include file="productTypeList.jsp" %>
		</SELECT> 
		Price: <input type="text" name="price" value="<%=btSearchLogic.getPrice()%>">
		<br>
		<br> <input type="hidden" name="mode" value="delAddJan2020"> <input
			type="submit" value="Regist">
	</form>
	

</body>

</html>