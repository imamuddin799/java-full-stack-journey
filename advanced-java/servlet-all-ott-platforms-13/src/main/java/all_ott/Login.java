package all_ott;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		PrintWriter pw = resp.getWriter();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginservlet?user=root&&password=root");
			String select = "select email, password from users where email = ?";
			ps = con.prepareStatement(select);
			ps.setString(1, email);
			rs = ps.executeQuery();

			String vEmail = null;
			String vPass = null;
			if (rs.next()) {
				vEmail = rs.getString(1);
				vPass = rs.getString(2);
				if (email.equals(vEmail) && pass.equals(vPass)) {
					pw.println("<!DOCTYPE html>\r\n"
							+ "<html lang='en'>\r\n"
							+ "<head>\r\n"
							+ "    <meta charset='UTF-8'>\r\n"
							+ "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\r\n"
							+ "    <title>OTT Platforms</title>\r\n"
							+ "    <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>\r\n"
							+ "</head>\r\n"
							+ "<body>\r\n"
							+ "    <div class='container'>\r\n"
							+ "        <h2 class='mt-4'>Popular OTT Platforms</h2>\r\n"
							+ "        <div class='row'>\r\n"
							+ "            <div class='col-md-4'>\r\n"
							+ "                <div class='card mb-4'>\r\n"
							+ "                    <img src='https://upload.wikimedia.org/wikipedia/commons/thumb/7/7a/Logonetflix.png/1200px-Logonetflix.png' class='card-img-top' alt='Netflix Logo'>\r\n"
							+ "                    <div class='card-body'>\r\n"
							+ "                        <h5 class='card-title'>Netflix</h5>\r\n"
							+ "                        <form action='https://www.netflix.com' method='get' target='_blank'>\r\n"
							+ "                            <button type='submit' class='btn btn-primary'>Visit</button>\r\n"
							+ "                        </form>\r\n"
							+ "                    </div>\r\n"
							+ "                </div>\r\n"
							+ "            </div>\r\n"
							+ "            <div class='col-md-4'>\r\n"
							+ "                <div class='card mb-4'>\r\n"
							+ "                    <img src='https://www.hatchwise.com/wp-content/uploads/2024/04/image-25.png.webp' class='card-img-top' alt='Hulu Logo'>\r\n"
							+ "                    <div class='card-body'>\r\n"
							+ "                        <h5 class='card-title'>Hulu</h5>\r\n"
							+ "                        <form action='https://www.hulu.com' method='get' target='_blank'>\r\n"
							+ "                            <button type='submit' class='btn btn-primary'>Visit</button>\r\n"
							+ "                        </form>\r\n"
							+ "                    </div>\r\n"
							+ "                </div>\r\n"
							+ "            </div>\r\n"
							+ "            <div class='col-md-4'>\r\n"
							+ "                <div class='card mb-4'>\r\n"
							+ "                    <img src='https://www.hatchwise.com/wp-content/uploads/2022/08/Amazon-Logo-2000-present-1536x864.jpeg.webp' class='card-img-top' alt='Amazon Prime Video Logo'>\r\n"
							+ "                    <div class='card-body'>\r\n"
							+ "                        <h5 class='card-title'>Amazon Prime Video</h5>\r\n"
							+ "                        <form action='https://www.amazon.com/Prime-Video/b?ie=UTF8&node=2676882011' method='get' target='_blank'>\r\n"
							+ "                            <button type='submit' class='btn btn-primary'>Visit</button>\r\n"
							+ "                        </form>\r\n"
							+ "                    </div>\r\n"
							+ "                </div>\r\n"
							+ "            </div>\r\n"
							+ "            <div class='col-md-4'>\r\n"
							+ "                <div class='card mb-4'>\r\n"
							+ "                    <img src='https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Disney%2B_logo.svg/1200px-Disney%2B_logo.svg.png' class='card-img-top' alt='Disney+ Logo'>\r\n"
							+ "                    <div class='card-body'>\r\n"
							+ "                        <h5 class='card-title'>Disney+</h5>\r\n"
							+ "                        <form action='https://www.disneyplus.com' method='get' target='_blank'>\r\n"
							+ "                            <button type='submit' class='btn btn-primary'>Visit</button>\r\n"
							+ "                        </form>\r\n"
							+ "                    </div>\r\n"
							+ "                </div>\r\n"
							+ "            </div>\r\n"
							+ "            <div class='col-md-4'>\r\n"
							+ "                <div class='card mb-4'>\r\n"
							+ "                    <img src='https://w7.pngwing.com/pngs/923/541/png-transparent-hbo-max-hd-logo.png' class='card-img-top' alt='HBO Max Logo'>\r\n"
							+ "                    <div class='card-body'>\r\n"
							+ "                        <h5 class='card-title'>HBO Max</h5>\r\n"
							+ "                        <form action='https://www.hbomax.com' method='get' target='_blank'>\r\n"
							+ "                            <button type='submit' class='btn btn-primary'>Visit</button>\r\n"
							+ "                        </form>\r\n"
							+ "                    </div>\r\n"
							+ "                </div>\r\n"
							+ "            </div>\r\n"
							+ "        </div>\r\n"
							+ "    </div>\r\n"
							+ "</body>\r\n"
							+ "</html>");
				} else {
					pw.println("<html><body>" + "<h2>Invalid Password</h2>" + "</body></html>");
					RequestDispatcher rd = req.getRequestDispatcher("login.html");
					rd.include(req, resp);
				}
			} else {
				pw.println("<html><body>" + "<h2>User does not Exists</h2>" + "</body></html>");
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.include(req, resp);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			pw.println("<html><body>" + "<h2>Database Exception</h2>" + "</body></html>");
			RequestDispatcher rd = req.getRequestDispatcher("register.html");
			rd.include(req, resp);
		} finally {
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