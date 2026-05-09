<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body bgcolor="cyan">
<%
	String email = request.getParameter("email");
	String pass = request.getParameter("pass");
	
	String demail = null;
	String dpass = null;
	String dname = null;
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_login?user=root&&password=root");
		String qry = "select email, pass, name from users where email = ? and pass = ?";
		ps = con.prepareStatement(qry);
		ps.setString(1, email);
		ps.setString(2, pass);
		rs = ps.executeQuery();
		if(rs.next()){
			demail = rs.getString(1);
			dpass = rs.getString(2);
			dname = rs.getString(3);
		}
		else{
			response.sendRedirect("register.jsp");
		}
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	} finally {
		if(rs != null){
			try{
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps != null){
			try{
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null){
			try{
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
%>
<h1>Welcome to home page <%= (dname != null ? dname : "") %></h1>
</body>
</html>