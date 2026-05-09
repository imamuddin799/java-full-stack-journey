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
	int square = Integer.parseInt(request.getParameter("square"));
	int divide = square / 2;
%>
<h2>The Divide by 2  is : <%= divide %></h2>
<h2>To get Divide by 0 click on Divide button</h2><br>
<form action="dividebyzero.jsp">
<input type="text" name="divide" style="display : none;" value="<%= divide %>">
<button>DivideByZero</button>
</form>
</body>
</html>