package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchAllRecords11 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&&password=root");
		System.out.println("Connection Successfull");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from student");
		System.out.println(rs);
		rs.next();
		System.out.println(rs.getInt(1) +" "+ rs.getString(2) +" "+ rs.getDouble(3));
		rs.next();
		System.out.println(rs.getInt(1) +" "+ rs.getString(2) +" "+ rs.getDouble(3));
		rs.next();
		System.out.println(rs.getInt(1) +" "+ rs.getString(2) +" "+ rs.getDouble(3));
		rs.next();
		System.out.println(rs.getInt(1) +" "+ rs.getString(2) +" "+ rs.getDouble(3));
		rs.next();
		System.out.println(rs.getInt(1) +" "+ rs.getString(2) +" "+ rs.getDouble(3));
		rs.next();
		System.out.println(rs.getInt(1) +" "+ rs.getString(2) +" "+ rs.getDouble(3));
		//here we'll get SQLException because we don't have any record available to display
		rs.next();
		System.out.println(rs.getInt(1) +" "+ rs.getString(2) +" "+ rs.getDouble(3));
	}
}