package strings_11.dec_06_06;

public class RemoveOccurrenceOfC04 {

	public static void main(String[] args) {
		String s = "This is a class";
		char c = 's';
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!(ch == c)) {
				res += ch;
			}
		}
		System.out.println(res);

		char c1 = (char) 1;

		for (int i = 0; i <= 127; i++, c1++) {
			System.out.println(c1 + " -> " + i);
		}
	}
}
