package objectdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertObject {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=root");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&&password=root");
		Statement stm = con.createStatement();
		Student s = new Student(1000, "Imamuddin Ansari", 90.5);
		
		System.out.println(s);
		
//		stm.execute is used to execute all kinds of sql statements
//		whereas stm.execute is used to execute only DML statements
//		stm.execute("insert into jdbc_steps.student values(101, 'Dimple', 79.5)");
//		stm.executeUpdate("insert into student values(102, 'Ramu', 65.5)");
//		System.out.println("Record Inserted");
		stm.executeUpdate("insert into student values("+ s +")");
		System.out.println("Record Inserted");
	}
}