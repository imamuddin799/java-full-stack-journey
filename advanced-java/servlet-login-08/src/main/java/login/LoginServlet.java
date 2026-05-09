package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

//		System.out.println(email +"\t"+ password);
		
		PrintWriter pw = resp.getWriter();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginservlet?user=root&&password=root");
			String qry = "select email, password from users where email = ?";
			ps = con.prepareStatement(qry);
			ps.setString(1, email);
			rs = ps.executeQuery();
			String varifyEmail = null;
			String varifyPassword = null;
			if (rs.next()) {
				varifyEmail = rs.getString(1);
				varifyPassword = rs.getString(2);
			}
			if(varifyEmail != null && varifyPassword != null) {
				if (varifyEmail.equals(email) && varifyPassword.equals(password)) {
					RequestDispatcher rd = req.getRequestDispatcher("home.html");
					rd.forward(req, resp);
				}
				else {
					pw.println("<html><head><link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'></head>");
					pw.println("<body>");
					pw.println("<h2 class='container bg-primary my-3 col-8'>Invalid Password</h2>");
					pw.println("</body></html>");
					RequestDispatcher rd = req.getRequestDispatcher("login.html");
					rd.include(req, resp);				
				}
			}
			else {
				pw.println("<html><head><link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'></head>");
				pw.println("<body>");
				pw.println("<h2 class='container bg-primary my-3 col-8'>The provided email is not present in the database</h2>");
				pw.println("</body></html>");
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.include(req, resp);	
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}