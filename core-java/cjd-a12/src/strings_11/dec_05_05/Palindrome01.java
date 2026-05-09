package strings_11.dec_05_05;

public class Palindrome01 {

	public static boolean palindrome(String s) {
		String r = "";
		for (int i = 0; i < s.length(); i++) {
			r = s.charAt(i) + r;
		}
		return r.equals(s);
	}

	public static void main(String[] args) {
		String s = "level of malayalam language is hard dad";
		String[] s1 = s.split(" ");
		for (String s2 : s1) {
			if (palindrome(s2)) {
				System.out.println(s2);
			}
		}
	}
}
