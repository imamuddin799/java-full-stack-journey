package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicUpdate09 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded and registered successfully");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&&password=root");
		System.out.println("Connection Established Successfully");

		String qry = "update student set sid = ?, name = ?, marks = ? where sid = ?";

		PreparedStatement ps = con.prepareStatement(qry);
		System.out.println("Platform Created");

		boolean condition = true;
		Scanner sc = new Scanner(System.in);
		while (condition) {
			System.out.println("Enter your choice");
			System.out.println("1 : Press '1' to update data");
			System.out.println("0 : Press '0' to exit\n");

			int ch = sc.nextInt();

			switch (ch) {
			case 1: {
				System.out.print("Enter old id : ");
				int oid = sc.nextInt();

				System.out.print("Enter new id : ");
				int id = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter name : ");
				String name = sc.nextLine();

				System.out.print("Enter marks : ");
				double marks = sc.nextDouble();

				ps.setInt(4, oid);
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setDouble(3, marks);

				ps.executeUpdate();
				System.out.println("Data Updated Successfully");
				
				break;
			}
			case 0: {
				System.out.println("Thanks visit again");
				condition = false;
				break;
			}
			}
		}
		sc.close();
	}
}