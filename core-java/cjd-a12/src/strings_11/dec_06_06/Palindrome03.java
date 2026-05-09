package strings_11.dec_06_06;

public class Palindrome03 {

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
			String palin = s.charAt(i) + "";
			for (int j = i + 1; j < s.length(); j++) {
				palin += s.charAt(j);
				if (isPalindrome(palin)) {
					System.out.println(palin);
				}
			}
		}
	}
}
