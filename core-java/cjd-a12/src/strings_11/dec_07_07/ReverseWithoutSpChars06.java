package strings_11.dec_07_07;

public class ReverseWithoutSpChars06 {

	public static void main(String[] args) {
		String s = "ab@28k&g2$8";
		String sp = "", st = "", res = "";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
				st = ch + st;
			} else {
				sp += ch;
			}
		}

		for (int i = 0, j = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (sp.contains(ch + "")) {
				res += ch;
			} else {
				res += st.charAt(j++);
			}
		}
		System.out.println(res);
	}
}
