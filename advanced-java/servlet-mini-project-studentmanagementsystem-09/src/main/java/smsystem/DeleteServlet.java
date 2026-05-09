package smsystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String email = (String) session.getAttribute("email");
		String password = (String) session.getAttribute("password");

		Connection con = null;
		PreparedStatement ps = null;
		
		PrintWriter pw = resp.getWriter();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem?user=root&&password=root");
			String delete = "delete from users where email = ? and password = ?";
			ps = con.prepareStatement(delete);
			ps.setString(1, email);
			ps.setString(2, password);
			ps.executeUpdate();
			
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.forward(req, resp);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			pw.println("<html><head><link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'></head>");
			pw.println("<body>");
			pw.println("<h2 class='container bg-primary my-3 col-4 rounded-3 py-1'>Something went wrong..!!!</h2>");
			pw.println("</body></html>");
			RequestDispatcher rd = req.getRequestDispatcher("register.html");
			rd.include(req, resp);
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
