package strings_11.dec_05_05.assignments;

public class AB2C3DEFG203 {

	public static void main(String[] args) {
		String s = "ab2c3defg2";
		String res = "";
		for (int i = 1; i < s.length(); i++) {
			char num = s.charAt(i);
			char ch = s.charAt(i - 1);
			if (num >= '1' && num <= '9') {
				for (int j = 1; j <= Integer.parseInt(num + ""); j++) {
					res += ch;
				}
			} else if (ch < '0' || ch > '9') {
				res += ch;
			}
		}
		System.out.println(res);
	}
}
