package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicDelete10 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded and registered successfully");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&&password=root");
		System.out.println("Connection Established Successfully");
		
		String qry1 = "delete from student where sid = ?";
		String qry2 = "delete from student where name = ?";
		String qry3 = "delete from student where marks = ?";
		
		PreparedStatement ps1 = con.prepareStatement(qry1);
		PreparedStatement ps2 = con.prepareStatement(qry2);
		PreparedStatement ps3 = con.prepareStatement(qry3);
		System.out.println("Platform Created Successfully");
		
		boolean condition = true;
		Scanner sc = new Scanner(System.in);
		while(condition) {
			System.out.println("Choose based on which column name you want to delete the data");
			System.out.println("1 : Press '1' for based on id");
			System.out.println("2 : Press '2' for based on name");
			System.out.println("3 : Press '3' for based on marks");
			System.out.println("0 : Press '0' to exit");
			
			int ch = sc.nextInt();
			
			switch(ch) {
			case 1 : {
				System.out.print("Enter student sid : ");
				int id = sc.nextInt();
				ps1.setInt(1, id);
				
				ps1.executeUpdate();
				System.out.println("Record deleted based on sid");
				
				break;
			}
			case 2 : {
				sc.nextLine();
				System.out.print("Enter student name : ");
				String name = sc.nextLine();
				ps2.setString(1, name);
				
				ps2.executeUpdate();
				System.out.println("Record deleted based on name");
				
				break;
			}
			case 3 : {
				System.out.print("Enter student marks : ");
				double marks = sc.nextDouble();
				ps3.setDouble(1, marks);
				
				ps3.executeUpdate();
				System.out.println("Record deleted based on marks");
				
				break;
			}
			case 0 : {
				System.out.println("Thanks visit again");
				condition = false;
			}
			}
		}
		sc.close();
	}
}