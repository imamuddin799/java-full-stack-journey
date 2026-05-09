package sendredirect_prog;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/log")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("em");
		String pass = req.getParameter("pw");
		
		if(email.equals("imamu@gmail.com") && pass.equals("imam123")) {
			resp.sendRedirect("https://www.youtube.com");
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("demo.html");
			rd.include(req, resp);
		}
	}
}