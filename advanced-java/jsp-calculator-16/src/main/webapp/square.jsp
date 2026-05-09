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
	int sum = Integer.parseInt(request.getParameter("sum"));
	int square = sum * sum;
%>
<h2>The square of number <%= sum %> is : <%= square %></h2>
<h2>To get Divide by 2 click on Divide button</h2><br>
<form action="divide.jsp">
<input type="text" name="square" style="display : none;" value="<%= square %>">
<button>Divide</button>
</form>
</body>
</html>