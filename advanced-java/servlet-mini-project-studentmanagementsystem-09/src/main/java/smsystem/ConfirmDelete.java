package smsystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConfirmDelete extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String email = (String) session.getAttribute("email");
		String password = (String) session.getAttribute("password");
		
		PrintWriter pw = resp.getWriter();
		pw.println("<!DOCTYPE html>\r\n"
		 		+ "<html lang='en'>\r\n"
		 		+ "<head>\r\n"
		 		+ "    <meta charset='UTF-8'>\r\n"
		 		+ "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\r\n"
		 		+ "    <title>Confirm Delete</title>\r\n"
		 		+ "    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet'\r\n"
		 		+ "        integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'>\r\n"
		 		+ "</head>\r\n"
				+ "<body class='bg-danger'>\r\n"
				+ "	<div class='container-fluid'>\r\n"
				+ "		<div class='container col-4 border border-danger rounded-3 my-3 bg-warning'>\r\n"
				+ "			<h2 class='text-danger my-3'>Warning</h2>\r\n"
				+ "			<h3 class='text-dark my-1'>Are you sure?</h3>\r\n"
				+ "			<h3 class='text-dark my-1'>Do you want to delete your account?</h3>\r\n"
				+ "			<form action='delete' method='post' class='d-inline'>\r\n"
				+ "				<button type='submit' class='btn btn-danger my-3 me-3'>Delete</button>\r\n"
				+ "			</form>\r\n"
				+ "			<form action='login' method='post' class='d-inline'>\r\n"
				+ "             <div class='form-floating my-3 d-none'>\r\n"
		 		+ "                 <input type='email' name='email' id='email' class='form-control d-none' placeholder='Enter Your Email : ' value='"+ email +"' >\r\n"
		 		+ "                 <label for='email' class='d-none'>Enter Your Email : </label>\r\n"
		 		+ "             </div>\r\n"
				+ "             <div class='form-floating my-3 d-none'>\r\n"
		 		+ "                 <input type='text' name='password' id='password' class='form-control d-none' placeholder='Enter Your Password : ' value='"+ password +"'>\r\n"
		 		+ "                 <label for='password' class='d-none'>Edit Password : </label>\r\n"
		 		+ "             </div>\r\n"
				+ "				<button type='submit' class='btn btn-primary my-3'>Cancel</button>\r\n"
				+ "			</form>\r\n"
				+ "		</div>\r\n"
				+ "	</div>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}
}