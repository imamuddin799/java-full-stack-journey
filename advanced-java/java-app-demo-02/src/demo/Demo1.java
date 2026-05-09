package demo;

import java.util.Scanner;

public class Demo1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.print("Enter your name : ");
//		String name = sc.nextLine();
		String name = "Imamuddin Ansari";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Hello "+ name +" ❤️");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();
	}
}