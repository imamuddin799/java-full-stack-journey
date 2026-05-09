package strings_11.dec_03_03;

public class FirstLast03 {

	public static String firstLast(String s) {
		String res = "";
		for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
			if (i == s.length() / 2 - 1) {
				res = res + s.charAt(j) + s.charAt(i);
			} else {
				res = res + s.charAt(i) + s.charAt(j);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String s = "abcdefgh";
		System.out.println(firstLast(s));
	}
}
