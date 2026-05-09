<%-- <%@page import="java.util.Scanner"%> --%>
<%@page import="java.util.ArrayList,java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">

<!-- Declaration Tag -->
<%! int a = 69; %>

<!-- Scriptlet Tag -->
<% 
	String name = request.getParameter("nm");
	out.println(name +"<br>");
	String email = request.getParameter("em");
	out.println(email +"<br>");
	String password = request.getParameter("pwd");
	out.println(password +"<br>");
	
	ArrayList al = new ArrayList();
	Scanner sc = new Scanner(System.in);
%>

<!-- Expression Tag -->
<%= a %>

</body>
</html>