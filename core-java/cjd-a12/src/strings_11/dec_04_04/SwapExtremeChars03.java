package strings_11.dec_04_04;

import java.util.Scanner;

public class SwapExtremeChars03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String res = "";
		int l = s.length();
		if (l < 2) {
			System.out.println(s);
		} else {
			res = s.charAt(l - 1) + s.substring(1, l - 1) + s.charAt(0);
		}
		System.out.println(res);
		sc.close();
	}
}
