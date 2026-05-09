package firstservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet extends GenericServlet{

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String fname = req.getParameter("firstname");
		String lname = req.getParameter("lastname");
		String email = req.getParameter("email");
		String dob = req.getParameter("dob");
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate dateOfBirth = LocalDate.parse(dob, format);
		
//		System.out.println(dateOfBirth);
		
		LocalDate today = LocalDate.now();
		
		Period age = Period.between(dateOfBirth, today);
		
		int realAge = age.getYears();
		if(age.getMonths() > 6) {
			realAge++;
		}
		
		System.out.println(age);
		
		System.out.println(age.getYears());
		
//		System.out.println(dateOfBirth +" "+ today);
		
		System.out.println(fname +" "+ lname +" "+ age.getYears() +" "+ email +" "+ dob);
		PrintWriter pw = res.getWriter();
		pw.println("<html> <body>");
		pw.println("<h1>Thanks for submitting the data</h1>");
		pw.println("<h1>First Name: "+fname+", Last Name: "+lname+", Age: "+realAge+", Email: "+email+", Date of Birth: "+dob+"</h1>");
		pw.println("</body> </html>");
		
//		Connection con = null;
//		PreparedStatement ps = null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstservlet?user=root&&password=root");
//			String qry = "insert into firstservlet values(?, ?, ?, ?, ?)";
//			ps = con.prepareStatement(qry);
//			ps.setString(1, fname);
//			ps.setString(2, lname);
//			ps.setInt(3, realAge);
//			ps.setString(4, email);
//			ps.setString(5, dob);
//			ps.executeUpdate();
//			
//			PrintWriter pw = res.getWriter();
//			pw.println("<html> <body>");
//			pw.println("<h1>Thanks for submitting the data</h1>");
//			pw.println("</body> </html>");
//			
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			PrintWriter pw = res.getWriter();
//			pw.println("<html> <body>");
//			pw.println("<h1>Data has not been added (Sorry)</h1>");
//			pw.println("</body> </html>");
//		}
//		finally {
//			if(ps != null) {
//				try {
//					ps.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
	}
}