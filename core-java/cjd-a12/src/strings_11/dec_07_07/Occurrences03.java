package strings_11.dec_07_07;

public class Occurrences03 {

	public static void main(String[] args) {
		String s = "abaacba";
		String d = "";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!d.contains(ch + "")) {
				int c = 1;
				for (int j = i + 1; j < s.length(); j++) {
					if (s.charAt(j) == ch) {
						c++;
					}
				}
				d += ch;
				System.out.println(ch + " -> " + c);
			}
		}
	}
}
