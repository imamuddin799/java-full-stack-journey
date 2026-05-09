package smsystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession session = req.getSession();
		 String name = (String) session.getAttribute("name");
		 String password = (String) session.getAttribute("password");
		 long phone = (long) session.getAttribute("phone");
		 Date dob = (Date) session.getAttribute("dob");
		 String email = (String) session.getAttribute("email");
		 String msg = (String) session.getAttribute("msg");
		 
		 PrintWriter pw = resp.getWriter();
		 pw.println("<!DOCTYPE html>\r\n"
		 		+ "<html lang='en'>\r\n"
		 		+ "<head>\r\n"
		 		+ "    <meta charset='UTF-8'>\r\n"
		 		+ "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\r\n"
		 		+ "    <title>Edit</title>\r\n"
		 		+ "    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet'\r\n"
		 		+ "        integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'>\r\n"
		 		+ "</head>\r\n"
		 		+ "<body class='bg-info'>\r\n"
		 		+ "    <form action='update' method='post'>\r\n"
		 		+ "        <div class='container-fluid d-flex align-items-center justify-content-center' style='height : 100vh; width : 100wh;'>\r\n"
		 		+ "			   <h2 class='container bg-primary  col-7 rounded-3 py-1 text-center d-"+(msg == null ? "none" : "block")+"'>"+ msg +"</h2>\r\n"		
		 		+ "            <div class='container bg-warning rounded-top mt-3 col-5 align-self-center'>\r\n"
		 		+ "                <h2 class='text-danger my-3'>Edit</h2>\r\n"
		 		+ "                <div class='form-floating my-3'>\r\n"
		 		+ "                    <input type='text' name='name' id='name' class='form-control' placeholder='Enter Your Name : '\r\n"
		 		+ "                        value='"+ name +"'>\r\n"
		 		+ "                    <label for='name'>Edit Name : </label>\r\n"
		 		+ "                </div>\r\n"
		 		+ "                <div class='form-floating my-3'>\r\n"
		 		+ "                    <input type='email' name='email' id='email' class='form-control'\r\n"
		 		+ "                        placeholder='Email cannot be changed : ' value='"+ email +"' readonly>\r\n"
		 		+ "                    <label for='email'>Email cannot be changed : </label>\r\n"
		 		+ "                </div>\r\n"
		 		+ "                <div class='form-floating my-3'>\r\n"
		 		+ "                    <input type='date' name='dob' id='dob' class='form-control' placeholder='Enter Your dob : '\r\n"
		 		+ "                        value='"+ dob +"'>\r\n"
		 		+ "                    <label for='dob'>Edit Date of Birth : </label>\r\n"
		 		+ "                </div>\r\n"
		 		+ "                <div class='form-floating my-3'>\r\n"
		 		+ "                    <input type='tel' name='phone' id='phone' class='form-control' placeholder='Enter Your Phone : '\r\n"
		 		+ "                        value='"+ phone +"'>\r\n"
		 		+ "                    <label for='phone'>Edit Phone : </label>\r\n"
		 		+ "                </div>\r\n"
		 		+ "                <div class='form-floating my-3'>\r\n"
		 		+ "                    <input type='text' name='password' id='password' class='form-control'\r\n"
		 		+ "                        placeholder='Enter Your Password : ' value='"+ password +"'>\r\n"
		 		+ "                    <label for='password'>Edit Password : </label>\r\n"
		 		+ "                </div>\r\n"
		 		+ "                <button type='submit' class='btn btn-primary mb-3 col-3 me-3 col-2 py-2'>Update</button>\r\n"
		 		+ "                <button type='reset' class='btn btn-success mb-3 col-3 me-3 col-2 py-2'>Reset</button>\r\n"
		 		+ "            </div>\r\n"
		 		+ "        </div>\r\n"
		 		+ "    </form>\r\n"
		 		+ "    <form action='login' method='post' class='d-inline'>\r\n"
		 		+ "        <div class='container-fluid'>\r\n"
		 		+ "            <div class='container rounded-bottom col-4' style='position: relative;'>\r\n"
		 		+ "                <div class='form-floating my-3 d-none'>\r\n"
		 		+ "                    <input type='email' name='email' id='email' class='form-control d-none'\r\n"
		 		+ "                        placeholder='Enter Your Email : ' value='"+ email +"'>\r\n"
		 		+ "                    <label for='email' class='d-none'>Enter Your Email : </label>\r\n"
		 		+ "                </div>\r\n"
		 		+ "                <div class='form-floating my-3 d-none'>\r\n"
		 		+ "                    <input type='text' name='password' id='password' class='form-control d-none'\r\n"
		 		+ "                        placeholder='Enter Your Password : ' value='"+ password +"'>\r\n"
		 		+ "                    <label for='password' class='d-none'>Edit Password : </label>\r\n"
		 		+ "                </div>\r\n"
		 		+ "                <button type='submit' class='btn btn-secondary text-light my-3 py-2 col-5' style='position: absolute; top: -230px; left: 293px;'>Show Student Details</button>\r\n"
		 		+ "            </div>\r\n"
		 		+ "        </div>\r\n"
		 		+ "    </form>\r\n"
		 		+ "</body>\r\n"
		 		+ "\r\n"
		 		+ "</html>");
		 msg = null;
		 session.setAttribute("msg", msg);
	}
}