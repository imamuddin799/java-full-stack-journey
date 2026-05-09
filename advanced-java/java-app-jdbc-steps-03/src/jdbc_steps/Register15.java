package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Register15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&&password=root");
			String insert = "insert into login values(?, ?)";
			ps = con.prepareStatement(insert);
			
			System.out.print("Enter username : ");
			String username = sc.nextLine();
			
			System.out.print("Enter password : ");
			String password = sc.nextLine();
			
			if(username.length() > 0 && password.length() > 0) {
				ps.setString(1, username);
				ps.setString(2, password);
				ps.executeUpdate();
				System.out.println("Credential Stored Successfully");
			}
			else {
				System.out.println("Please enter valid credentials");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
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