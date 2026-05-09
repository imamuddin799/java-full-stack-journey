package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertMultipleRecords05 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&&password=root");
		System.out.println("Connection successful");
		Statement stm = con.createStatement();
		stm.executeUpdate("insert into student values(106, 'Imam', 90)");
		stm.executeUpdate("insert into student values(107, 'Ansari', 80)");
		stm.executeUpdate("inser into student values(108, 'Sahil', 70)");
		stm.executeUpdate("insert into student values(109, 'Bhai', 75)");
		System.out.println("Inserted successfully");
	}
}