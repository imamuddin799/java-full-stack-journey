package strings_11.dec_06_06.assignments;

public class Reverse02 {

	public static String reverseWithoutSpecialChar(String s) {
		String rev = "";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch >= '0' && ch <= '9' || ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') {
				rev = s.charAt(i) + rev;
			}
		}
		return rev;
	}

	public static void main(String[] args) {
		String s = "Ab$5H2@G92&n";
		String rev = reverseWithoutSpecialChar(s);
		String res = "";
		for (int i = 0, j = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch >= '0' && ch <= '9' || ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') {
				res += rev.charAt(j++);
			} else {
				res += s.charAt(i);
			}
		}
		System.out.println(res);
	}
}
