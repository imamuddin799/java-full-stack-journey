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

public class RegisterServlet extends HttpServlet {

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
			String q = "select email from users where email = ?";
			ps = con.prepareStatement(q);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				String varifyEmail = rs.getString(1);
				pw.println("<html><head><link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'></head>");
				pw.println("<body>");
				pw.println("<h2 class='container bg-primary my-3 col-8'>Already have an account with this email</h2>");
				pw.println("</body></html>");
				RequestDispatcher rd = req.getRequestDispatcher("register.html");
				rd.include(req, resp);
			} else {
				if (email.length() >= 1 && password.length() >= 1) {
					String qry = "insert into users values(?, ?)";
					ps = con.prepareStatement(qry);
					ps.setString(1, email);
					ps.setString(2, password);
					ps.executeUpdate();

					pw.println(
							"<html><head><link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'></head>");
					pw.println("<body>");
					pw.println("<h2 class='container bg-primary my-3 col-8'>Registration Successful</h2>");
					pw.println("</body></html>");
					RequestDispatcher rd = req.getRequestDispatcher("login.html");
					rd.forward(req, resp);
				} else {
					pw.println(
							"<html><head><link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'></head>");
					pw.println("<body>");
					pw.println("<h2 class='container bg-primary my-3 col-8'>Email and Password cannot be empty</h2>");
					pw.println("</body></html>");
					RequestDispatcher rd = req.getRequestDispatcher("register.html");
					rd.include(req, resp);
				}
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