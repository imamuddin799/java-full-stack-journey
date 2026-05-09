package calculation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Square extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int num = Integer.parseInt(req.getParameter("num3"));
//		int num = Integer.parseInt(req.getParameter("z"));
		
//		int num = (int) req.getAttribute("z");
		
		HttpSession session = req.getSession();
		
		
		int num = (int) session.getAttribute("z");
		
		int sq = num * num;
		
		session.setAttribute("sq", sq);
		
		PrintWriter pw = resp.getWriter();
		
//		pw.println("<html><body><h1>Square of number "+ num +" is : "+ sq +"</h1></body></html>");
		
		pw.println("<html><body><h1>Square of number " + num +" is : " + sq 
				+ "<h1>To get Division by 0 click on Divide button</h1><br>"
				+ "<form action='divide' method='get'>"
				+ "<button type='submit'>Divide</button>"
				+ "</form"
				+ "</h1></body></html>");
	}
}
