package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login16 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&&password=root");

			System.out.print("Enter your email : ");
			String email = sc.nextLine();

			System.out.print("Enter your password : ");
			String password = sc.nextLine();

			String qry = "select * from login where email = ?";
			ps = con.prepareStatement(qry);
			ps.setString(1, email);

			rs = ps.executeQuery();
			if (rs.next()) {
				String varifyEmail = rs.getString(1);
				String varifyPassword = rs.getString(2);

				if (email.equals(varifyEmail) && password.equals(varifyPassword)) {
					System.out.println("Login Successful");
				} else {
					System.out.println("Please enter valid username and password");
				}
			} else {
				System.out.println("You have not registered yet. You should register first then try to login");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
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
			sc.close();
		}
	}
}