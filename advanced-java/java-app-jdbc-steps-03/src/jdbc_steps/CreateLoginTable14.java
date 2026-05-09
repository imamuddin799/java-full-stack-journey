package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateLoginTable14 {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Class Loaded and Registered");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps", "root", "root");
			System.out.println("Connection established");
			stmt = con.createStatement();
			System.out.println("Platform created");
			stmt.execute("create table login(email varchar(100) not null, password varchar(20) not null, primary key(email))");
			System.out.println("Table created");
		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}