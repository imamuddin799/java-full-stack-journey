package strings_11.dec_05_05.assignments;

public class Palindrome01 {

	public static boolean isPalindrome(String s) {
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			res = s.charAt(i) + res;
		}
		return res.equals(s);
	}

	public static void main(String[] args) {
		String s = "khkjk12321kjkhjabaja";
		for (int i = 0; i < s.length(); i++) {
			String palin = "";
			for (int j = i; j < s.length(); j++) {
				palin += s.charAt(j);
				if (palin.length() >= 2 && isPalindrome(palin)) {
					System.out.println(palin);
				}
			}
		}
	}
}
