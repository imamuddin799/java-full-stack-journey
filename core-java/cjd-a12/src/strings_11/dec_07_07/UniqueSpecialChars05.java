package strings_11.dec_07_07;

import java.util.Scanner;

public class UniqueSpecialChars05 {

	public static boolean special(char ch) {
		return ch < '0' || ch > '9' && ch < 'A' || ch > 'Z' && ch < 'a' || ch > 'z';
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a String to find Unique Special characters : ");
		String s = sc.nextLine();
		String d = "";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!d.contains(ch + "") && special(ch)) {
				int c = 1;
				for (int j = i + 1; j < s.length(); j++) {
					if (s.charAt(j) == ch) {
						c++;
					}
				}
				d += ch;
				if (c == 1)
					System.out.println(ch + " -> " + c);
			}
		}
		sc.close();
	}
}
