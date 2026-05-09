package strings_11.dec_07_07;

import java.util.Scanner;

public class DuplicateVowels02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a String to find duplicate vowels : ");
		String s = sc.nextLine();
		String v = "aeiouAEIOU";
		String d = "";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!d.contains(ch + "") && v.contains(ch + "")) {
				int c = 1;
				for (int j = i + 1; j < s.length(); j++) {
					if (s.charAt(j) == ch) {
						c++;
					}
				}
				d += ch;
				if (c >= 2)
					System.out.println(ch + " -> " + c);
			}
		}
		sc.close();
	}
}
