package calculation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Add extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		int sum = num1 + num2;
		PrintWriter pw = resp.getWriter();
		
		HttpSession session = req.getSession();
		session.setAttribute("z", sum);

//		pw.println("<html><body><h1>Sum of Two numbers " + num1 + " and " + num2 + " is : " + sum + "</h1></body></html>");

//		pw.println("<html><body><h1>To get Square click on Square</h1><form action=\"square\">\r\n"
//				+ "        <input hidden type=\"number\" name=\"num3\" id=\"num3\" value=\""+ sum +"\"><br>\r\n"
//				+ "        <button type=\"submit\">Square</button>\r\n"
//				+ "    </form></body></html>");
		
		pw.println("<html><body><h1>Sum of Two numbers " + num1 + " and " + num2 + " is : " + sum 
				+ "<h1>To get Square click on Square button</h1><br>"
				+ "<form action='square' method='get'>"
				+ "<button type='submit'>Square</button>"
				+ "</form"
				+ "</h1></body></html>");
		

//		req.setAttribute("z", sum);

//		RequestDispatcher rd = req.getRequestDispatcher("square?z=" + sum);
//		rd.forward(req, resp);
	}
}