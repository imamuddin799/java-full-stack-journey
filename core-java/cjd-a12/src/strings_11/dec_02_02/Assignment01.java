package strings_11.dec_02_02;

public class Assignment01 {

	public static void main(String[] args) {
		String s = "abcdefgh";
		String res = "";
		int len = s.length();
		for (int j = 0; j < len; j++) {
			if (j % 2 == 0) {
				res += s.charAt(j);
			}
		}
		for (int j = 0; j < len; j++) {
			if (j % 2 != 0) {
				res += s.charAt(j);
			}
		}
		System.out.println(res.toUpperCase());

		res = "";
		res += s.substring(len / 2);
		res += s.substring(0, len / 2);
		System.out.println(res.toUpperCase());

		String up = s.toUpperCase();
		String low = s.toLowerCase();
		res = "";
		for (int i = 0; i < len; i++) {
			if (i % 2 == 0) {
				res += up.charAt(i);
			} else
				res += low.charAt(i);
		}
		System.out.println(res);
	}
}
