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
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	private static String correctDate(String s) {
		if (!s.equals("null")) {
			String res = "";

			String s1[] = s.split("-");
			for (String s2 : s1) {
				res = "-" + s2 + res;
			}
			res = res.substring(1);
			return res;
		} else {
			return "Not available";
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String msg = (String) session.getAttribute("msg");

		PrintWriter pw = resp.getWriter();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem?user=root&&password=root");
			
			String qry = "select email, password, name, dob, phone from users where email = ?";
			ps = con.prepareStatement(qry);
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			String varifyEmail = null;
			String varifyPassword = null;
			String name = null;
			Date dob = null;
			long phone = 0;

			if (rs.next()) {
				varifyEmail = rs.getString(1);
				varifyPassword = rs.getString(2);
				name = rs.getString(3);
				dob = rs.getDate(4);
				phone = rs.getLong(5);
			}
			if (varifyEmail != null && varifyPassword != null) {
				if (varifyEmail.equals(email) && varifyPassword.equals(password)) {
//					RequestDispatcher rd = req.getRequestDispatcher("home.html");
//					rd.forward(req, resp);

					session.setAttribute("name", name);
					session.setAttribute("email", email);
					session.setAttribute("password", password);
					session.setAttribute("phone", phone);
					session.setAttribute("dob", dob);

					pw.println("<!doctype html>\r\n"
							+ "<html lang='en'>\r\n"
							+ "<head><title>Student Details</title>\r\n"
							+ "    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css' rel='stylesheet'\r\n"
							+ "        integrity='sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN' crossorigin='anonymous' />\r\n"
							+ "</head><body class='bg-info'>\r\n"
							+ "    <div class='container-fluid d-flex flex-column align-items-center justify-content-center' style='height : 100vh; width : 100wh;'>\r\n"
							+ "        <h2 class='container bg-primary  col-7 rounded-3 py-1 text-center d-"+(msg == null ? "none" : "block")+"'>"+ msg +"</h2>\r\n"
							+ "        <div class='container bg-warning col-7 mt-3 py-2 rounded-3 align-self-center'>\r\n"
							+ "            <h1 class='mb-3 text-danger'>Student Details</h1>"
							+ "            <div class='container border border-danger col-12 bg-success my-2 rounded-3'>\r\n"
							+ "                <label for='name' class='h2 col-5'>Student Name : </label>\r\n"
							+ "                <h2 class='d-inline col-7 text-light'>" + name.toUpperCase() + "</h2>\r\n"
							+ "            </div>\r\n"
							+ "            <div class='container border border-danger col-12 bg-success my-2 rounded-3'>\r\n"
							+ "                <label for='name' class='h2 col-5'>Student Email : </label>\r\n"
							+ "                <h2 class='d-inline col-7 text-light'>" + email + "</h2>\r\n"
							+ "            </div>\r\n"
							+ "            <div class='container border border-danger col-12 bg-success my-2 rounded-3'>\r\n"
							+ "                <label for='name' class='h2 col-5'>Student Phone : </label>\r\n"
							+ "                <h2 class='d-inline col-7 text-light'>" + (phone == 0 ? "Not available" : phone) + "</h2>\r\n"
							+ "            </div>\r\n"
							+ "            <div class='container border border-danger col-12 bg-success my-2 rounded-3'>\r\n"
							+ "                <label for='name' class='h2 col-5'>Student Date of Birth : </label>\r\n"
							+ "                <h2 class='d-inline col-7 text-light'>" + correctDate(dob + "") + "</h2>\r\n"
							+ "            </div>\r\n" 
							+ "			   <div class='container col-12 px-0'>\r\n"
							+ "				   <form action='edit' method='post' class='d-inline'>\r\n"
							+ "                    <button type='submit' class='btn btn-primary my-2 col-2 me-3 fs-4'>Edit</button>\r\n"
							+ "                </form>\r\n"
							+ "				   <button type='button' class='btn btn-danger col-2 fs-4' data-bs-toggle='modal' data-bs-target='#exampleModal'>Delete</button>\r\n"
							+ "    <div class='modal' id='exampleModal' tabindex='-1' aria-labelledby='exampleModalLabel' aria-hidden='true'>\r\n"
							+ "        <div class='modal-dialog modal-dialog-centered'>\r\n"
							+ "            <div class='modal-content'>\r\n"
							+ "                <div class='modal-header'>\r\n"
							+ "                    <h5 class='modal-title text-danger' id='exampleModalLabel'>Warning</h5>\r\n"
							+ "                    <button type='button' class='btn-close' data-bs-dismiss='modal' aria-label='Close'></button>\r\n"
							+ "                </div>\r\n"
							+ "                <div class='modal-body'>\r\n"
							+ "                    <p class='text-dark my-1'>Are you sure?</p>\r\n"
							+ "                    <p class='text-dark my-1'>Do you want to delete your account?</p>\r\n"
							+ "                </div>\r\n"
							+ "                <div class='modal-footer'>\r\n"
							+ "                    <form action='delete' method='post' class='d-inline'>\r\n"
							+ "                        <button type='submit' class='btn btn-danger'>Delete</button>\r\n"
							+ "                    </form>\r\n"
							+ "                    <button type='button' class='btn btn-secondary' data-bs-dismiss='modal'>Close</button>\r\n"
							+ "                </div>\r\n"
							+ "            </div>\r\n"
							+ "        </div>\r\n"
							+ "    </div>\r\n"
							+ "    <script src='https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js'\r\n"
							+ "        integrity='sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r'\r\n"
							+ "        crossorigin='anonymous'></script>\r\n"
							+ "    <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js'\r\n"
							+ "        integrity='sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+'\r\n"
							+ "        crossorigin='anonymous'></script>"
							+ "            </div>" 
							+ "        </div>\r\n" 
							+ "    </div>\r\n" 
							+ "</body>\r\n"
							+ "</html>");
					msg = null;
					session.setAttribute("msg", msg);
				} else {
					pw.println("\r\n"
							+ "<html><head><title>Login</title>\r\n"
							+ "    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet'\r\n"
							+ "        integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'>\r\n"
							+ "</head><body class='bg-info'>\r\n"
							+ "    <div class='container-fluid d-flex flex-column justify-content-end' style='position: absolute; top: 24%;'>\r\n"
							+ "        <h2 class='container bg-primary my-3 col-3 rounded-3 py-1 align-self-end'>Invalid Password</h2>\r\n"
							+ "    </div></body></html>");
					RequestDispatcher rd = req.getRequestDispatcher("login.html");
					rd.include(req, resp);
				}
			} else {
				pw.println("<html><head><title>Login</title>\r\n"
						+ "    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet'\r\n"
						+ "        integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'>\r\n"
						+ "</head><body class='bg-info'>\r\n"
						+ "    <div class='container-fluid d-flex flex-column justify-content-end' style='position: absolute; top: 24%;'>\r\n"
						+ "        <h2 class='container bg-primary my-3 col-3 rounded-3 py-1 align-self-end'>The user does not exists</h2>\r\n"
						+ "    </div></body></html>");
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.include(req, resp);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			pw.println("<html><head><title>Login</title>\r\n"
					+ "    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet'\r\n"
					+ "        integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'>\r\n"
					+ "</head><body class='bg-info'>\r\n"
					+ "    <div class='container-fluid d-flex flex-column justify-content-end' style='position: absolute; top: 24%;'>\r\n"
					+ "        <h2 class='container bg-primary my-3 col-3 rounded-3 py-1 align-self-end'>Something went wrong..!!!</h2>\r\n"
					+ "    </div></body></html>");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
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