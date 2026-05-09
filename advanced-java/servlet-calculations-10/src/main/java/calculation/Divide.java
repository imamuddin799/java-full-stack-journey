package calculation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Divide extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int sq = (int) (session.getAttribute("sq"));
		
		PrintWriter pw = resp.getWriter();
		
//		try {
//			int division = sq/0;
//			pw.println("<html><body><h1>Division of number "+ sq +" is : "+ division +"</h1></body></html>");
//		} catch (Throwable e) {
//			e.printStackTrace();
//			pw.println("<html><body><h1>Cannot divide by zero</h1></body></html>");
//		}
		
		int division = sq/0;
		pw.println("<html><body><h1>Division of number "+ sq +" is : "+ division +"</h1></body></html>");
	}
}