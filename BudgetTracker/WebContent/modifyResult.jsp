<%@ page language="java" contentType="text/html;charset=Windows-31J"%>

<html>
<head>
<title></title>
</head>
<body>
	<br>

	<%
		boolean status = (boolean) request.getAttribute("bool");
		String message = null;
		if (status = true) {
			message = "Success";
		} else {
			message = "Failed";
		}
	%>

	<br>
	<br>
	<%=message%>
	<br>
	<br>

	<a href="./mainpage.jsp">トップページに戻る</a>


</body>
</html>
