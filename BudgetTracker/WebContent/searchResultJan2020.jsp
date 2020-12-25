<%@ page language="java" contentType="text/html;charset=Windows-31J"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="info.budget.budgettracker.BudgetTrackerSearchDto"%>
;

<html>
<head>
<title></title>
</head>
<body>
	<br>

	<%
	List<BudgetTrackerSearchDto> rset = (List<BudgetTrackerSearchDto>) request.getAttribute("SqlResult");
	%>
	<!-- �����ł��ꂼ��̗񖼂�\�� -->
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
			(int data : rset) {
		%>
		<tr>
			<td><%=this.getId%></td>
			<td><%=this.getDate%></td>
			<td><%=this.getStoreName%></td>
			<td><%=this.getProductName%></td>
			<td><%=this.getType%></td>
			<td><%=this.getPrice%></td>
			<td><a href="BudgetTrackerDeleteController?&mode=deleteJan2020&id=<%=rset.getString(1)%>">Delete</a></td>
			<td>
				<form action="/BudgetTracker/BudgetTrackerDeleteController" method="POST">
					<input type="hidden" name="mode" value="change"> 
					<input
						type="hidden" name="id" value="<%=this.getId%>"> 
					<input
						type="hidden" name="date" value="<%=this.getDate%>">
					<input type="hidden" name="storeName" value="<%=this.getStoreName%>">
					<input type="hidden" name="productName" value="<%=this.getProductName%>">
					<input type="hidden" name="type" value="<%=this.getType%>">
					<input type="hidden" name="price" value="<%=this.getPrice%>">
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
