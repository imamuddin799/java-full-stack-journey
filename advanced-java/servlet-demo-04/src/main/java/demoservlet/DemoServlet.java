package demoservlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoServlet extends GenericServlet {

	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello Baby");
	}
}