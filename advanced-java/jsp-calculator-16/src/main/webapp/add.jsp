<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="nav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
	<%
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	int sum = num1 + num2;
	%>
	<h2>The sum of numbers <%=num1%> and <%=num2%> is : <%=sum%></h2>
	<h2>To get Square of <%=sum%> click on Square button</h2><br>
	<form action="square.jsp">
		<input type="text" name="sum" style="display: none;" value="<%=sum%>">
		<button>Square</button>
	</form>
</body>
</html>