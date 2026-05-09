package strings_11.dec_04_04;

public class Palindrome02 {

	public static String reverse(String s) {
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			res = s.charAt(i) + res;
//			System.out.println(res);
		}
		return res;
	}

	public static void main(String[] args) {
		String s = "the level of malayalam language is difficult dad";
		String s1[] = s.split(" ");
		for (String s2 : s1) {
			if (s2.equals(reverse(s2))) {
				System.out.println(s2);
			}
		}
	}
}
