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
	<!-- �����ł��ꂼ��̗񖼂�\�� -->
	<table border="1">
		<tr bgcolor="#cccccc">
			<td><b>Store Name</b></td>	
			<td><b>Price</b></td>	
		</tr>
		<%
			//BudgetTrackerSearchDto btsDto = new BudgetTrackerSearchDto();
			for (BudgetTrackerSearchDto btsDto : rset) {
		%>
		<tr>
			<td><%=btsDto.getStoreName()%></td>		
			<td><%=btsDto.getPrice()%></td>	
		</tr>
		<%
			}
		%>
	</table>

	<br>

	<a href="./mainpage.jsp">Going back to the top</a>

</body>
</html>
