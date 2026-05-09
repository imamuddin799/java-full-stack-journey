package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateRecord03 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&&password=root");
		System.out.println("Connection Established Successfully");
		
		Statement stm = con.createStatement();
		System.out.println("Plateform Created Successfully");
		
		stm.executeUpdate("update student set sid = 104, name = 'Rajkumar', marks = 63.5 where sid = 102 and name = 'Ramu' order by sid, name Limit 1");
		System.out.println("Data updated sucessfully");
		
		ResultSet rs = stm.executeQuery("select * from student order by marks desc");
		while(rs.next()) {
			System.out.print(rs.getInt(1) +"\t");
			System.out.print(rs.getString(2) +"\t");
			System.out.print(rs.getDouble(3) +"\n");
		}
		
		stm.close();
		con.close();
	}
}