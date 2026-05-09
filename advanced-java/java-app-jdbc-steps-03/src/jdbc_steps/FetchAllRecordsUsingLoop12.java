package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FetchAllRecordsUsingLoop12 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&&password=root");
		System.out.println("Connection successs");
		
		String qry = "select * from student where sid = ?";
		PreparedStatement ps = con.prepareStatement(qry);
		System.out.print("Enter student id to display record : ");
		int sid = sc.nextInt();
		ps.setInt(1, sid);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1) +" "+ rs.getString(2) +" "+ rs.getDouble(3));
		}
		
		
		
		
		
//		this is not possible to do
//		String qry = "select * from ?";
//		PreparedStatement ps = con.prepareStatement(qry);
//		System.out.print("Enter table name to display record : ");
//		String tname = sc.nextLine();
//		ps.setString(1, tname);
//		
//		ResultSet rs = ps.executeQuery();
//		while(rs.next()) {
//			System.out.println(rs.getInt(1) +" "+ rs.getString(2) +" "+ rs.getDouble(3));
//		}
		
		sc.close();
	}
}