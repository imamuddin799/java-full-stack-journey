package servletlifecycle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/log", loadOnStartup = 5)
public class LifeCycle extends HttpServlet {
	
//	phase-1
	public LifeCycle() {
		System.out.println("phase-1 executed");
	}
	
//	phase-2
	@Override
	public void init() throws ServletException {
		System.out.println("phase-2 executed");
	}

//	phase-3
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("phase-3 execuded");
		System.out.println(req.getParameter("em"));
		System.out.println(req.getParameter("pw"));
	}
	
//	phase-4
	@Override
	public void destroy() {
		System.out.println("phase-4 executed");
	}
}