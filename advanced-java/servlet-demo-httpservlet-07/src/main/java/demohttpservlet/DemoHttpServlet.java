package demohttpservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoHttpServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int eid = Integer.parseInt(req.getParameter("eid"));
		String ename = req.getParameter("ename");
		String hiredate = req.getParameter("hdate");
		double salary = Double.parseDouble(req.getParameter("salary"));
		String jobrole = req.getParameter("jobrole");
		String dOB = req.getParameter("dateOfBirth");
		int age;
		
		LocalDate today = LocalDate.now();
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate dateOfBirth = LocalDate.parse(dOB, format);
		
		Period realAge = Period.between(dateOfBirth, today);
		if(realAge.getMonths() > 6) {
			age = realAge.getYears() + 1;
		} else {
			age = realAge.getYears();
		}
		
//		System.out.println(eid);
//		System.out.println(ename);
//		System.out.println(hiredate);
//		System.out.println(salary);
//		System.out.println(jobrole);
//		System.out.println(dOB);
//		System.out.println(age);
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demohttp?user=root&&password=root");
			
			String qry = "insert into employee values(?, ?, ?, ?, ?, ?, ?)";
			
			ps = con.prepareStatement(qry);
			
			ps.setInt(1, eid);
			ps.setString(2, ename);
			ps.setString(3, hiredate);
			ps.setDouble(4, salary);
			ps.setString(5, jobrole);
			ps.setString(6, dOB);
			ps.setInt(7, age);
			
			int rows = ps.executeUpdate();
			
			PrintWriter pw = resp.getWriter();
			pw.println("<html lang='en'>");
			pw.println("<head>");
			pw.println("<title>Form Submission</title>");
			pw.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
			pw.println("</head>");
			pw.println("<body class='d-flex justify-content-center align-items-center vh-100'>");
			pw.println("<div class='container text-center'>");
			pw.println("<div class='p-5 rounded shadow-lg bg-light border border-success'>");
			pw.println("<h1 class='text-success'>Thank You!</h1>");
			pw.println("<p>Your submission was successful.</p>");
			pw.println("<p>Number of rows get affected : "+ rows +"</p>");
			pw.println("</div>");
			pw.println("<a href='index.html' class='btn btn-primary mt-3'>Go Back</a>");
			pw.println("</div>");
			pw.println("</body>");
			pw.println("</html>");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			PrintWriter pw = resp.getWriter();
			pw.println("<html lang='en'>");
			pw.println("<head>");
			pw.println("<title>Form Submission</title>");
			pw.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
			pw.println("</head>");
			pw.println("<body class='d-flex justify-content-center align-items-center vh-100'>");
			pw.println("<div class='container text-center'>");
			pw.println("<div class='p-5 rounded shadow-lg bg-light border border-success'>");
			pw.println("<h1 class='text-danger'>Submission Failed</h1>");
			pw.println("<p>There was an issue with your submission. Please try again.</p>");
			pw.println("</div>");
			pw.println("<a href='index.html' class='btn btn-primary mt-3'>Go Back</a>");
			pw.println("</div>");
			pw.println("</body>");
			pw.println("</html>");
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