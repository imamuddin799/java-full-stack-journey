package strings_11.dec_06_06;

public class AB2C3DEFG201 {

	public static boolean isDigit(char ch) {
		return ch >= '0' && ch <= '9';
	}

	public static void main(String[] args) {
		String s = "AB2C3DEFG2H";
		String res = "";
		for (int i = 0; i < s.length() - 1; i++) {
			char ch = s.charAt(i);
			char ch2 = s.charAt(i + 1);
			if (!isDigit(ch)) {
				if (isDigit(ch2)) {
					for (char c = '1'; c <= ch2; c++) {
						res += ch;
					}
				} else {
					res += ch;
				}
			}
		}
		char c = s.charAt(s.length() - 1);
		if (!isDigit(c)) {
			res += c;
		}
		System.out.println(res);
	}
}
