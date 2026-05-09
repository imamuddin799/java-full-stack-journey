<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #111;
}

.active {
	background-color: #04AA6D;
}
</style>
</head>
<body>
	<ul>
		<li><a class="active" href="index.jsp">Addition</a></li>
		<li><a href="dividebyzero.jsp">Subtraction</a></li>
		<li><a href="square.jsp">Multiplication</a></li>
		<li><a href="divide.jsp">Division</a></li>
	</ul>
</body>
</html>


