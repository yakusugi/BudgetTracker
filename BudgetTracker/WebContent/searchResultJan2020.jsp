<%@ page language="java" contentType="text/html;charset=Windows-31J"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="info.budget.budgettracker.BudgetTrackerSearchDto"%>

<html>
<head>
<title></title>
</head>
<body>
	<br>

	<%
	List<BudgetTrackerSearchDto> rset = (List<BudgetTrackerSearchDto>) request.getAttribute("SqlResult");
	%>
	<!-- ‚±‚±‚Å‚»‚ê‚¼‚ê‚Ì—ñ–¼‚ð•\Ž¦ -->
	<table border="1">
		<tr bgcolor="#cccccc">
			<td><b>ID</b></td>
			<td><b>Date</b></td>
			<td><b>Store Name</b></td>
			<td><b>Product Name</b></td>
			<td><b>Type</b></td>
			<td><b>Price</b></td>
			<td><b>Delete</b></td>
			<td><b>Modify</b></td>
		</tr>
		<%
			//BudgetTrackerSearchDto btsDto = new BudgetTrackerSearchDto();
			for (BudgetTrackerSearchDto btsDto : rset) {
		%>
		<tr>
			<td><%=btsDto.getId()%></td>
			<td><%=btsDto.getDate()%></td>
			<td><%=btsDto.getStoreName()%></td>
			<td><%=btsDto.getProductName()%></td>
			<td><%=btsDto.getType()%></td>
			<td><%=btsDto.getPrice()%></td>
			<td><a href="BudgetTrackerDeleteController?&mode=deleteJan2020&id=<%=btsDto.getId()%>">Delete</a></td>
			<td>
				<form action="/BudgetTracker/BudgetTrackerDeleteController" method="POST">
					<input type="hidden" name="mode" value="change"> 
					<input
						type="hidden" name="id" value="<%=btsDto.getId()%>"> 
					<input
						type="hidden" name="date" value="<%=btsDto.getDate()%>">
					<input type="hidden" name="storeName" value="<%=btsDto.getStoreName()%>">
					<input type="hidden" name="productName" value="<%=btsDto.getProductName()%>">
					<input type="hidden" name="type" value="<%=btsDto.getType()%>">
					<input type="hidden" name="price" value="<%=btsDto.getPrice()%>">
					<input type="submit" value="Modify">
				</form>
			</td>
		</tr>
		<%
			}
		%>
	</table>

	<br>

	<a href="./mainpage.jsp">Going back to the top</a>

</body>
</html>
