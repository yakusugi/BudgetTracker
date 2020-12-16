<%@ page language="java" contentType="text/html;charset=Windows-31J"%>
<%@page import="java.sql.*"%>

<html>
<head>
<title></title>
</head>
<body>
	<br>

	<%
		ResultSet rset = (ResultSet) request.getAttribute("SqlResult");
	%>
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
			while (rset.next()) {
		%>
		<tr>
			<td><%=rset.getString(1)%></td>
			<td><%=rset.getString(2)%></td>
			<td><%=rset.getString(3)%></td>
			<td><%=rset.getString(4)%></td>
			<td><%=rset.getString(5)%></td>
			<td><%=rset.getString(6)%></td>
			<td><a href="BTController?&mode=delete&id=<%=rset.getString(1)%>">Delete</a></td>
			<td>
				<form action="/BudgetTracker/BTController" method="POST">
					<input type="hidden" name="mode" value="change"> 
					<input
						type="hidden" name="id" value="<%=rset.getString(1)%>"> 
					<input
						type="hidden" name="date" value="<%=rset.getString(2)%>">
					<input type="hidden" name="storeName" value="<%=rset.getString(3)%>">
					<input type="hidden" name="productName" value="<%=rset.getString(4)%>">
					<input type="hidden" name="type" value="<%=rset.getString(5)%>">
					<input type="hidden" name="price" value="<%=rset.getString(6)%>">
					<input type="submit" value="Modify">
				</form>
			</td>
		</tr>
		<%
			}
		%>
	</table>

	<br>

	<a href="./index.jsp">Going back to the top</a>

</body>
</html>
