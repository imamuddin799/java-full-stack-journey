package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatement07 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Class loaded and registered successfully");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&&password=root");
		System.out.println("Connection Established Successfully");
		
		String qry = "insert into student values(?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(qry);
		System.out.println("Platform Created");
		
		ps.setInt(1, 5001);
		ps.setString(2, "Amit");
		ps.setDouble(3, 70.0);
		
		ps.setInt(1, 5002);
		ps.setString(2, "Rohan");
		ps.setDouble(3, 70.0);
		
		
//		here only this record will be inserted the above data will not be inserted
		ps.setInt(1, 5003);
		ps.setString(2, "Rajkumar");
		ps.setDouble(3, 70.0);
		ps.executeUpdate();
		System.out.println("Data inserted successfully");
	}
}