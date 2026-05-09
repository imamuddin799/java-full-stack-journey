<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body bgcolor="cyan">

<%
	String email = request.getParameter("email");
	String pass = request.getParameter("pass");
	String name = request.getParameter("name");
	
	Connection con = null;
	PreparedStatement ps = null;
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_login?user=root&&password=root");
		String qry = "insert into users values(?, ?, ?)";
		ps = con.prepareStatement(qry);
		ps.setString(1, email);
		ps.setString(2, pass);
		ps.setString(3, name);
		ps.executeUpdate();
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	} finally {
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
	<form action="home.jsp">
		<label>Enter Email : </label> <input type="email" name="email" value="<%= email != null ? email : "" %>"><br>
		<label>Enter Password : </label> <input type="text" name="pass" value="<%= pass != null ? pass : "" %>"><br>
		<button>Submit</button>
	</form>
</body>
</html>