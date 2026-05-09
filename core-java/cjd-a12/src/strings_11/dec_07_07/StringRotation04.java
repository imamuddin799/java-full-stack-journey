package strings_11.dec_07_07;

import java.util.Scanner;

public class StringRotation04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string to rotate : ");
		String s = sc.nextLine();
		System.out.print("Enter bolean value (true || false) : ");
		boolean b = sc.nextBoolean();
		System.out.print("Enter number of characters to rotate : ");
		int n = sc.nextInt();
		String res = "";
		if(b) {
			res = s.substring(n) + s.substring(0, n);
		}
		else {
			res = s.substring(s.length()-n)+ s.substring(0, s.length()-n);
		}
		System.out.println(res);
		sc.close();
	}
}
