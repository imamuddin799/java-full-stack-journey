package smsystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
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

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String getPhone = req.getParameter("phone");
		Date dOB = null;
		if (!req.getParameter("dob").equals("")) {
			dOB = Date.valueOf(req.getParameter("dob"));
		}
		long phone = 0;
		if (!getPhone.equals("")) {
			phone = Long.parseLong(req.getParameter("phone"));
		}
		String password = req.getParameter("password");
		name = name.trim();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		PrintWriter pw = resp.getWriter();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem?user=root&&password=root");

			String q = "select email from users where email = ?";
			ps = con.prepareStatement(q);
			ps.setString(1, email);
			rs = ps.executeQuery();

			if (rs.next()) {
				String varifyEmail = rs.getString(1);
				pw.println("<html><head><title>Register</title>\r\n"
						+ "    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet'\r\n"
						+ "        integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'>\r\n"
						+ "</head><body class='bg-info'>\r\n"
						+ "    <div class='container-fluid d-flex flex-column justify-content-end' style='position: absolute; top: 11%;'>\r\n"
						+ "        <h2 class='container bg-primary my-3 col-3 rounded-3 py-1 align-self-end'>User already exists</h2>\r\n"
						+ "    </div></body></html>");
				RequestDispatcher rd = req.getRequestDispatcher("register.html");
				rd.include(req, resp);
			} else {
				if (email.length() >= 1 && password.length() >= 1 && name.length() >= 1) {
					String qry = "insert into users values(?, ?, ?, ?, ?)";
					ps = con.prepareStatement(qry);

					ps.setString(1, name);
					ps.setDate(2, dOB);
					ps.setString(3, email);
					ps.setLong(4, phone);
					ps.setString(5, password);

					int row = ps.executeUpdate();
					if (row > 0) {
						
//						pw.println("<html><head><link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'></head>");
//						pw.println("<body>");
//						pw.println("<h2 class='container bg-primary my-3 col-4 rounded-3 py-1'>Registration Successful</h2>");
//						pw.println("</body></html>");
						
						RequestDispatcher rd = req.getRequestDispatcher("login.html");
						rd.forward(req, resp);
					} else {
						pw.println("<html><head><title>Register</title>\r\n"
								+ "    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet'\r\n"
								+ "        integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'>\r\n"
								+ "</head><body class='bg-info'>\r\n"
								+ "    <div class='container-fluid d-flex flex-column justify-content-end' style='position: absolute; top: 11%;'>\r\n"
								+ "        <h2 class='container bg-primary my-3 col-3 rounded-3 py-1 align-self-end'>Registration Failed</h2>\r\n"
								+ "    </div></body></html>");
						RequestDispatcher rd = req.getRequestDispatcher("register.html");
						rd.include(req, resp);
					}

				} else {
					pw.println("<html><head><title>Register</title>\r\n"
							+ "    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet'\r\n"
							+ "        integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'>\r\n"
							+ "</head><body class='bg-info'>\r\n"
							+ "    <div class='container-fluid d-flex flex-column justify-content-end' style='position: absolute; top: 11%;'>\r\n"
							+ "        <h2 class='container bg-primary my-3 col-6 rounded-3 py-1 align-self-end'>Email, Password and Name cannot be empty</h2>\r\n"
							+ "    </div></body></html>");
					RequestDispatcher rd = req.getRequestDispatcher("register.html");
					rd.include(req, resp);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			pw.println("<html><head><title>Register</title>\r\n"
					+ "    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet'\r\n"
					+ "        integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'>\r\n"
					+ "</head><body class='bg-info'>\r\n"
					+ "    <div class='container-fluid d-flex flex-column justify-content-end' style='position: absolute; top: 11%;'>\r\n"
					+ "        <h2 class='container bg-primary my-3 col-4 rounded-3 py-1 align-self-end'>Something went wrong..!!!</h2>\r\n"
					+ "    </div></body></html>");
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