package smsystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String msg = null;
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Date dob = null;
		if(!req.getParameter("dob").equals(""))
				dob = Date.valueOf(req.getParameter("dob"));
		long phone = 0;
		if (!req.getParameter("phone").equals("")) {
			phone = Long.parseLong(req.getParameter("phone"));
		}

		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;

		PrintWriter pw = resp.getWriter();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem?user=root&&password=root");

			String select = "select name, phone, password, dob from users where email = ?";
			ps = con.prepareStatement(select);
			ps.setString(1, email);
			rs = ps.executeQuery();

			String vName = null;
			long vPhone = 0;
			String vPassword = null;
			Date vDoB = null;

			if (rs.next()) {
				vName = rs.getString(1);
				vPhone = rs.getLong(2);
				vPassword = rs.getString(3);
				vDoB = rs.getDate(4);
			}

			if (name.equals("")) {
				name = vName;
			}
			if (phone == 0) {
				phone = vPhone;
			}
			if (password.equals("")) {
				password = vPassword;
			}
			if (dob == null) {
				dob = vDoB;
			}

			String update = "update users set name = ?, dob = ?, phone = ?, password = ? where email = ?";
			ps1 = con.prepareStatement(update);
			ps1.setString(1, name);
			ps1.setDate(2, dob);
			ps1.setLong(3, phone);
			ps1.setString(4, password);
			ps1.setString(5, email);

			int row = ps1.executeUpdate();
			
			if (row > 0) {
				
				msg = "Data Updated Successfully";
				session.setAttribute("name", name);
				session.setAttribute("dob", dob);
				session.setAttribute("phone", phone);
				session.setAttribute("password", password);
				session.setAttribute("msg", msg);
				
//				System.out.println(name);
//				System.out.println(dob);
//				System.out.println(phone);
//				System.out.println(password);
//				System.out.println(email);
//				
//				try {
//		            // Stop MySQL Abandoned Cleanup Thread
//		            try {
//		                com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.uncheckedShutdown();
//		            } catch (Exception e) {
//		            	e.printStackTrace();
//		            }
//
//		            // Deregister JDBC Drivers
//		            Enumeration<Driver> drivers = DriverManager.getDrivers();
//		            while (drivers.hasMoreElements()) {
//		                Driver driver = drivers.nextElement();
//		                try {
//		                    DriverManager.deregisterDriver(driver);
//		                } catch (Exception e) {
//		                	e.printStackTrace();
//		                }
//		            }
//		        } catch (Exception e) {
//		        	e.printStackTrace();
//		        }

				RequestDispatcher rd = req.getRequestDispatcher("login?password="+ password);
				rd.forward(req, resp);
			} else {
				msg = "Data Updation Failed";
				session.setAttribute("msg", msg);
				pw.println("<html><head><link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'></head>");
				pw.println("<body>");
				pw.println("<h2 class='container bg-secondary text-danger my-3 col-4 rounded-3 py-1'>Data Updation Failed</h2>");
				pw.println("</body></html>");
				RequestDispatcher rd = req.getRequestDispatcher("edit");
				rd.forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			msg = "Something went wrong..!!!";
			session.setAttribute("msg", msg);
//			pw.println("<html><head><link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'></head>");
//			pw.println("<body>");
//			pw.println("<h2 class='container bg-primary my-3 col-4 rounded-3 py-1'>Something went wrong..!!!</h2>");
//			pw.println("</body></html>");
			RequestDispatcher rd = req.getRequestDispatcher("register.html");
			rd.include(req, resp);
		}
		finally {
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
			if (ps1 != null) {
				try {
					ps1.close();
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