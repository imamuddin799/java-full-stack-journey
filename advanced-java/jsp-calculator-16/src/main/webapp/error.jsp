<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%@ include file="nav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
	<%-- <%=exception.getMessage() %> --%>
	<%
	if(response.getStatus() == 500){
	%>
	<font color="red">Error : <%= exception.getMessage() %></font><br>
	<% } else { %>
	Hi There, error code is
	<%=response.getStatus() %><br> Please go to 
	<a href="index.jsp">home page</a>
	<% } %>
</body>
</html>