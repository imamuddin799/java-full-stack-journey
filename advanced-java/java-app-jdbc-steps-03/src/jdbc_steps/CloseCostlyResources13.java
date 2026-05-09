package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CloseCostlyResources13 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&&password=root");
			st = con.createStatement();
			st.executeUpdate("insert into student values(5001, 'Dimple', 90.0)");
			System.out.println("data inserted...");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(st != null) {
				try {
					st.close();
					System.out.println("st closed...");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
					System.out.println("con closed...");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}