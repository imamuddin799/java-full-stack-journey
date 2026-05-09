package strings_11.dec_03_03;

public class Toggle04 {

	public static String toggle(String s) {
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (i % 2 == 0) {
				res = res + (ch + "").toUpperCase();
			} else {
				res = res + (ch + "").toLowerCase();
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String s = "abcdefgh";
		System.out.println(toggle(s));
	}
}
