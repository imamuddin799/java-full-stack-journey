package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable01 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Class Loaded and Registered");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			System.out.println("Connection established");
			Statement stmt = con.createStatement();
			System.out.println("Platform created");
			stmt.execute("create table jdbc_steps.employee(eid int, ename varchar(25),salary double, eaddress varchar(150))");
			System.out.println("Table created");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}