package all_ott;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/register")
public class Register extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		PrintWriter pw = resp.getWriter();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginservlet?user=root&&password=root");
			String select = "select email, password from users where email = ?";
			ps = con.prepareStatement(select);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				pw.println("<html><body>" + "<h2>User Already Exists</h2>" + "</body></html>");
				RequestDispatcher rd = req.getRequestDispatcher("register.html");
				rd.include(req, resp);
			} else {
				if (!email.equals("") && !pass.equals("") && !"null".equals(email + "") && !"null".equals(pass + "")) {
					String insert = "insert into users values(?, ?)";
					ps = con.prepareStatement(insert);
					ps.setString(1, email);
					ps.setString(2, pass);
					int row = ps.executeUpdate();
					if (row > 0) {
						RequestDispatcher rd = req.getRequestDispatcher("login.html");
						rd.forward(req, resp);
					} else {
						pw.println("<html><body>" + "<h2>Could not be inserted</h2>" + "</body></html>");
						RequestDispatcher rd = req.getRequestDispatcher("register.html");
						rd.include(req, resp);
					}
				} else {
					pw.println("<html><body>" + "<h2>Empty Fields Are Not Allowed</h2>" + "</body></html>");
					RequestDispatcher rd = req.getRequestDispatcher("register.html");
					rd.include(req, resp);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			pw.println("<html><body>" + "<h2>Database Exception</h2>" + "</body></html>");
			RequestDispatcher rd = req.getRequestDispatcher("register.html");
			rd.include(req, resp);
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