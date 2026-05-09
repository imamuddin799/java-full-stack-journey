package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicInsert08 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Class loaded and registered successfully");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&&password=root");
		System.out.println("Connection Established Successfully");
		
		String qry = "insert into student values(?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(qry);
		System.out.println("Platform Created");
		boolean condition = true;
		Scanner sc = new Scanner(System.in);
		while(condition) {
			System.out.println("Enter your choice");
			System.out.println("1: Add record");
			System.out.println("0: exit");
			int ch = sc.nextInt();
			switch(ch) {
			case 1 :
				System.out.println("Enter id of the student");
				int id = sc.nextInt();
				ps.setInt(1, id);
				sc.nextLine();
				
				System.out.println("Enter name of the student");
				String name = sc.nextLine();
				ps.setString(2, name);
				
				System.out.println("Enter marks of the student");
				double marks = sc.nextDouble();
				ps.setDouble(3, marks);
				
				ps.executeUpdate();
				System.out.println("Data inserted Successfully");
				break;
			case 0 : 
				System.out.println("Thanks visit again");
				condition = false;
				break;
			}
		}
		sc.close();
	}
}