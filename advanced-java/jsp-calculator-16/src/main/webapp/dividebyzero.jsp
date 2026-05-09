<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@ include file="nav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int divide = Integer.parseInt(request.getParameter("divide"));
	int divideByZero = divide / 0;
%>
<h2>The Divide by 0  is : <%= divideByZero %></h2>
</body>
</html>