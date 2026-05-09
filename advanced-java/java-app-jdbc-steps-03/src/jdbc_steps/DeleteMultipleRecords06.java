package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteMultipleRecords06 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&&password=root");
		
		Statement stm = con.createStatement();
		
		stm.executeUpdate("delete from student where name = 'Ramu'");
		stm.executeUpdate("delete from student where name = 'Raju'");
		stm.executeUpdate("delete from student where name = 'Rajkumar'");
		stm.executeUpdate("delete from student where name = 'Dimple'");
		
		System.out.println("Records deleted successfully");
	}
}