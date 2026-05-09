package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRecord04 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Class loaded and registered successfully");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&&password=root");
		System.out.println("Connection Established Successfully");
		
		Statement stm = con.createStatement();
		System.out.println("Platform Created");
		
		stm.executeUpdate("delete from student where name = 'Ramu'");
		System.out.println("Record Deleted Successfully");
	}
}