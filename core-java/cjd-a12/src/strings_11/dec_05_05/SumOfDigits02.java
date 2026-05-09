package strings_11.dec_05_05;

public class SumOfDigits02 {

	public static void main(String[] args) {
		String s = "ab28c1k9";
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch >= '1' && ch <= '9') {
				sum += Integer.parseInt(ch + "");
			}
		}
		System.out.println(sum);
	}
}
